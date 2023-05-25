DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `create_document_table`()
BEGIN
	CREATE TEMPORARY TABLE `document_table` (
	  `parameter_project` VARCHAR(45) NULL,
	  `parameter_class_type_id` INT NULL,
	  `diagram_id` BIGINT NULL,
	  `diagram_title` VARCHAR(255) NULL,
	  `diagram_description` VARCHAR(255) NULL,
	  `diagram_project` VARCHAR(255) NULL,
	  `class_id` VARCHAR(45) NULL,
	  `class_name` VARCHAR(45) NULL,
	  `class_inner_class` TINYINT NULL,
	  `class_diagram_id` BIGINT NULL,
	  `class_class_type_id` VARCHAR(45) NULL,
	  `class_type_id` INT NULL,
	  `class_type_name` VARCHAR(45) NULL,
	  `method_id` INT NULL,
	  `method_abstract` TINYINT NULL,
	  `method_name` VARCHAR(45) NULL,
	  `method_return_type` VARCHAR(45) NULL,
	  `method_class_id` VARCHAR(45) NULL,
	  `method_access_type_id` INT NULL,
	  `access_type_id` INT NULL,
	  `access_type_name` VARCHAR(45) NULL,
	  `parameter_id` INT NULL,
	  `parameter_name` VARCHAR(45) NULL,
	  `parameter_type` VARCHAR(45) NULL,
	  `parameter_method_id` INT NULL);
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `insert_access_types`()
BEGIN
	UPDATE document_table
	JOIN access_type ON document_table.method_access_type_id = access_type.id
	SET access_type_id = access_type.id, access_type_name = access_type.name_;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `insert_class_types`()
BEGIN
	UPDATE document_table
	JOIN class_type ON document_table.class_class_type_id = class_type.id
	SET class_type_id = class_type.id, class_type_name = class_type.name_;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `insert_classes`()
BEGIN
	UPDATE document_table
	JOIN class ON document_table.method_class_id = class.id
	SET class_id = class.id, class_name = class.name_, class_inner_class = class.inner_class,
	class_diagram_id = class.diagram_id, class_class_type_id = class.class_type_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `insert_diagrams`()
BEGIN
	UPDATE document_table
	JOIN diagram ON document_table.class_diagram_id = diagram.id
	SET diagram_id = diagram.id, diagram_title = diagram.title, diagram_description = diagram.description, diagram_project = diagram.project;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `insert_parameters`(IN `project` VARCHAR(45), IN `class_type_id` INT)
BEGIN
	INSERT INTO document_table (parameter_id, parameter_name, parameter_type, parameter_method_id)
	SELECT parameter.id, parameter.name_, parameter.type_, parameter.method_id FROM parameter
	JOIN method ON parameter.method_id = method.id
	JOIN class ON method.class_id = class.id
	JOIN diagram on class.diagram_id = diagram.id
	WHERE diagram.project = project AND class.class_type_id = class_type_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `insert_procedure_parameters`(IN `project` VARCHAR(45), IN `class_type_id` INT)
BEGIN
	UPDATE document_table
	SET parameter_project=project, parameter_class_type_id=class_type_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `generate_document_table`(IN `project` VARCHAR(45), IN `class_type_id` INT)
BEGIN
	SET SQL_SAFE_UPDATES=0;

	CALL create_document_table();
    CALL insert_parameters(project, class_type_id);
    CALL insert_methods(project, class_type_id);
    CALL insert_access_types();
    CALL insert_classes();
    CALL insert_class_types();
    CALL insert_diagrams();
    CALL insert_procedure_parameters(project, class_type_id);
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `insert_methods`(IN `project` VARCHAR(45), IN `class_type_id` INT)
BEGIN
	UPDATE document_table
	JOIN method ON document_table.parameter_method_id = method.id
	SET method_id = method.id, method_abstract = method.abstract, method_name = method.name_, method_return_type = method.return_type,
    method_class_id = method.class_id, method_access_type_id = method.access_type_id;

    CREATE TEMPORARY TABLE temp_table SELECT * FROM document_table;

    INSERT INTO document_table (method_id, method_abstract, method_name, method_return_type, method_class_id, method_access_type_id)
    SELECT method.id, method.abstract, method.name_, method.return_type, method.class_id, method.access_type_id FROM method
    JOIN class ON method.class_id = class.id
    JOIN diagram ON class.diagram_id = diagram.id
    WHERE method.id NOT IN (SELECT parameter_method_id FROM temp_table) AND diagram.project = project AND class.class_type_id = class_type_id;
END$$
DELIMITER ;
