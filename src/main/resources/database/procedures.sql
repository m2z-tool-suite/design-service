DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `document_create_table`()
BEGIN
	CREATE TEMPORARY TABLE `document_table` (
	  `parameter_project` VARCHAR(45) NULL,
	  `parameter_class_type_id` BIGINT NULL,
	  `diagram_id` BIGINT NULL,
	  `diagram_title` VARCHAR(255) NULL,
	  `diagram_description` VARCHAR(255) NULL,
	  `diagram_project` VARCHAR(255) NULL,
	  `class_id` VARCHAR(45) NULL,
	  `class_name` VARCHAR(45) NULL,
	  `class_inner_class` TINYINT NULL,
	  `class_diagram_id` BIGINT NULL,
	  `class_class_type_id` VARCHAR(45) NULL,
	  `class_type_id` BIGINT NULL,
	  `class_type_name` VARCHAR(45) NULL,
	  `method_id` BIGINT NULL,
	  `method_abstract` TINYINT NULL,
	  `method_name` VARCHAR(45) NULL,
	  `method_return_type` VARCHAR(45) NULL,
	  `method_class_id` VARCHAR(45) NULL,
	  `method_access_type_id` BIGINT NULL,
	  `access_type_id` BIGINT NULL,
	  `access_type_name` VARCHAR(45) NULL,
	  `parameter_id` BIGINT NULL,
	  `parameter_name` VARCHAR(45) NULL,
	  `parameter_type` VARCHAR(45) NULL,
	  `parameter_method_id` BIGINT NULL);
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `document_generate_table`(IN `project` VARCHAR(45), IN `class_type_id` INT)
BEGIN
	SET SQL_SAFE_UPDATES=0;

	CALL document_create_table();
    CALL document_insert_parameters(project, class_type_id);
    CALL document_insert_methods(project, class_type_id);
    CALL document_insert_access_types();
    CALL document_insert_classes();
    CALL document_insert_class_types();
    CALL document_insert_diagrams();
    CALL document_insert_procedure_parameters(project, class_type_id);
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `document_insert_access_types`()
BEGIN
	UPDATE document_table
	JOIN access_type ON document_table.method_access_type_id = access_type.id
	SET access_type_id = access_type.id, access_type_name = access_type.name_;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `document_insert_class_types`()
BEGIN
	UPDATE document_table
	JOIN class_type ON document_table.class_class_type_id = class_type.id
	SET class_type_id = class_type.id, class_type_name = class_type.name_;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `document_insert_classes`()
BEGIN
	UPDATE document_table
	JOIN class ON document_table.method_class_id = class.id
	SET class_id = class.id, class_name = class.name_, class_inner_class = class.inner_class,
	class_diagram_id = class.diagram_id, class_class_type_id = class.class_type_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `document_insert_diagrams`()
BEGIN
	UPDATE document_table
	JOIN diagram ON document_table.class_diagram_id = diagram.id
	SET diagram_id = diagram.id, diagram_title = diagram.title, diagram_description = diagram.description, diagram_project = diagram.project;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `document_insert_methods`(IN `project` VARCHAR(45), IN `class_type_id` INT)
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

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `document_insert_parameters`(IN `project` VARCHAR(45), IN `class_type_id` INT)
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
CREATE DEFINER=`root`@`%` PROCEDURE `document_insert_procedure_parameters`(IN `project` VARCHAR(45), IN `class_type_id` INT)
BEGIN
	UPDATE document_table
	SET parameter_project=project, parameter_class_type_id=class_type_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `graph_create_table`()
BEGIN
	CREATE TEMPORARY TABLE `graph_table` (
	  `parameter_project` VARCHAR(45) NULL,
	  `diagram_id` BIGINT NULL,
	  `diagram_title` VARCHAR(255) NULL,
	  `diagram_description` VARCHAR(255) NULL,
	  `diagram_project` VARCHAR(255) NULL,
	  `parent_class_id` VARCHAR(45) NULL,
	  `parent_class_name` VARCHAR(45) NULL,
	  `parent_class_inner_class` TINYINT NULL,
	  `parent_class_diagram_id` BIGINT NULL,
	  `parent_class_class_type_id` VARCHAR(45) NULL,
	  `parent_class_type_id` BIGINT NULL,
	  `parent_class_type_name` VARCHAR(45) NULL,
	  `child_class_id` VARCHAR(45) NULL,
	  `child_class_name` VARCHAR(45) NULL,
	  `child_class_inner_class` TINYINT NULL,
	  `child_class_diagram_id` BIGINT NULL,
	  `child_class_class_type_id` VARCHAR(45) NULL,
	  `child_class_type_id` BIGINT NULL,
	  `child_class_type_name` VARCHAR(45) NULL,
      `relationship_type_id` BIGINT NULL,
      `relationship_type_name` VARCHAR(255) NULL,
      `relationship_id` BIGINT NULL,
      `relationship_relationship_type_id` BIGINT NULL,
      `relationship_parent_class_id` VARCHAR(45) NULL,
      `relationship_child_class_id` VARCHAR(45) NULL);
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `graph_generate_table`(IN `project` VARCHAR(45))
BEGIN
	SET SQL_SAFE_UPDATES=0;

    CALL graph_create_table();
    CALL graph_insert_relationships(project);
    CALL graph_insert_relationship_types();
    CALL graph_insert_child_classes();
    CALL graph_insert_child_class_types();
    CALL graph_insert_parent_classes();
    CALL graph_insert_parent_class_types();
    CALL graph_insert_diagrams();
    CALL graph_insert_procedure_parameters(project);
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `graph_insert_child_class_types`()
BEGIN
	UPDATE graph_table
	JOIN class_type ON graph_table.child_class_class_type_id = class_type.id
	SET child_class_type_id = class_type.id, child_class_type_name = class_type.name_;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `graph_insert_child_classes`()
BEGIN
	UPDATE graph_table
	JOIN class ON graph_table.relationship_child_class_id = class.id
	SET child_class_id = class.id, child_class_name = class.name_, child_class_inner_class = class.inner_class,
	child_class_diagram_id = class.diagram_id, child_class_class_type_id = class.class_type_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `graph_insert_diagrams`()
BEGIN
	UPDATE graph_table
	JOIN diagram ON graph_table.parent_class_diagram_id = diagram.id
	SET diagram_id = diagram.id, diagram_title = diagram.title, diagram_description = diagram.description, diagram_project = diagram.project;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `graph_insert_parent_class_types`()
BEGIN
	UPDATE graph_table
	JOIN class_type ON graph_table.parent_class_class_type_id = class_type.id
	SET parent_class_type_id = class_type.id, parent_class_type_name = class_type.name_;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `graph_insert_parent_classes`()
BEGIN
	UPDATE graph_table
	JOIN class ON graph_table.relationship_parent_class_id = class.id
	SET parent_class_id = class.id, parent_class_name = class.name_, parent_class_inner_class = class.inner_class,
	parent_class_diagram_id = class.diagram_id, parent_class_class_type_id = class.class_type_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `graph_insert_procedure_parameters`(IN `project` VARCHAR(45))
BEGIN
	UPDATE graph_table
	SET parameter_project=project;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `graph_insert_relationship_types`()
BEGIN
	UPDATE graph_table
	JOIN relationship_type ON graph_table.relationship_relationship_type_id = relationship_type.id
	SET relationship_type_id = relationship_type.id, relationship_type_name = relationship_type.name_;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `graph_insert_relationships`(IN `project` VARCHAR(45))
BEGIN
	INSERT INTO graph_table (relationship_id, relationship_relationship_type_id, relationship_parent_class_id, relationship_child_class_id)
	SELECT relationship.id, relationship.relationship_type_id, relationship.parent_class_id, relationship.child_class_id FROM relationship
	JOIN class ON relationship.parent_class_id = class.id OR relationship.child_class_id = class.id
	JOIN diagram ON class.diagram_id = diagram.id
	WHERE diagram.project = project
    GROUP BY relationship.id;
END$$
DELIMITER ;
