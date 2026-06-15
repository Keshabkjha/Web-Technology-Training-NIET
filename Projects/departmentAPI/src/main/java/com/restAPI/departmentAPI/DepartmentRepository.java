package com.restAPI.departmentAPI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository 
extends 
CrudRepository<Department, Long> 
{
	// JPA WILL TAKE AUTOMATICALLY

	
}
