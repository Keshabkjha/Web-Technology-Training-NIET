package com.restAPI.departmentAPI;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
// TO GIVE 4 SERVICES FOR DEPARTMENT 
// REST FULL API ON WEBSERVICE(MICROSERVICE)
@Service  
public class DepartmentServiceImpl implements DepartmentService{
	
    @Autowired
    private DepartmentRepository dpr;
 
    // Save operation
	/*
    @Override
	public Department saveDepartment(Department department) {
		
		return (Department) dpr.save(department);
	}
	*/
    
    public Department saveDepartment(Department department) throws Exception {
    	int retryCount = 3; for (int i = 0; i < retryCount; i++) 
    	{ try { return dpr.save(department); } 
    	catch (ObjectOptimisticLockingFailureException e) {
    		if (i == retryCount - 1) { 
    			throw new Exception("Conflict occurred while saving the department", e);
    			} // Optionally, add a delay before retrying Thread.sleep(1000); } } return null; // Should never reach here }
    	}
    }
		return department;
    
    }

	// Read or select Operations
	@Override
	public List<Department> fetchDepartmentList() {
		
		return (List<Department>)
	            dpr.findAll();

	}

	@Override
	public Department updateDepartment(Department department, Long departmentId) {
		
		Department depDB
        = (Department) dpr.findById(departmentId).get();

    if (Objects.nonNull(department.getDepartmentName())
        && !"".equalsIgnoreCase(
            (String) department.getDepartmentName())) {
        depDB.setDepartmentName(
            department.getDepartmentName());
    }

    if (Objects.nonNull(
            department.getDepartmentAddress())
        && !"".equalsIgnoreCase(
            department.getDepartmentAddress())) {
        depDB.setDepartmentAddress(
            department.getDepartmentAddress());
    }

    if (Objects.nonNull(department.getDepartmentCode())
        && !"".equalsIgnoreCase(
            department.getDepartmentCode())) {
        depDB.setDepartmentCode(
            department.getDepartmentCode());
    }

    return (Department) dpr.save(depDB);

	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		
        dpr.deleteById(departmentId);
		
	}
	
	
}
