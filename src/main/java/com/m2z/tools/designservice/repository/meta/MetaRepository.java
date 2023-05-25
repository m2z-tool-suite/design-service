package com.m2z.tools.designservice.repository.meta;

import com.m2z.tools.designservice.model.meta.Meta;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaRepository extends CrudRepository<Meta, Long> {}
