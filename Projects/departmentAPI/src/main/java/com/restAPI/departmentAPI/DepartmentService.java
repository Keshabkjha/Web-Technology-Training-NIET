package com.restAPI.departmentAPI;

import java.util.List;
// this interfACE provides LOOSE COUPLING
// AVOID TIGHT COUPLING
// HAS ABSTRACT CRUD OPERATIONS
// 4- 1. READ, 2. UPDATE, SAVE, DELETE
public interface DepartmentService {
	
	// Save operation
    Department saveDepartment(Department department) throws Exception;
 
    // Read operation
    List<Department> fetchDepartmentList();
     // Update operation
    Department updateDepartment(Department department,
                                Long departmentId);
 
    // Delete operation
    void deleteDepartmentById(Long departmentId);

}
