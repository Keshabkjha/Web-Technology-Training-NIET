package com.restAPI.departmentAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.validation.annotation.Validated;
//import jakarta.validation.valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

// to have web appliction
@RestController
//  http://localhost:8084/api/departments/hello
// type in browser to see output
@RequestMapping("/api")
// creating url endpoint for the user
// or online client
public class DepartmentController {

    // Annotation  // field DI Injection
    @Autowired 
    private DepartmentService departmentService; 

    // Greeting Endpoint 
    @GetMapping("/hello")
	public String greet() {
		return "Hello World from Department Rest API... ";
    }

    // End Point Save operation  in REST API
/*
 * // insert a product into database
   @PostMapping
   public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
     Product savedProduct = productService.saveProduct(product);
     return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
   }
 * 
 */
    // use http post method to insert
    // new records int the table
    @PostMapping("/departments")
    public ResponseEntity<Department> saveDepartment(
       @Valid        
       @RequestBody 
       Department department) throws Exception
    {
    	Department savdep = departmentService.saveDepartment(department);
        //return departmentService.saveDepartment(department);
    	return new ResponseEntity<> (savdep, HttpStatus.CREATED);
    }
    
    // End Point for Read operation  in REST API
 // http://localhost:8084/api/departments   
   // is used with http protocol to 
    //Get to read all record from table
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    } 
    
    // End Point for Update operation in REST API
    // http://localhost:8084/api/departments/2
    // put with http used to change or 
    // update records in table
    @PutMapping("departments/{id}")
    public Department
    updateDepartment(@RequestBody Department department,
                     @PathVariable("id") Long departmentId)
    {
    	//Department upd = 
        return departmentService.updateDepartment(department, departmentId);
    }

    // End Point for Delete operation in REST API
    // with http used to delet a record
    // from table provid key value
 //http://localhost:8084/api/departments/2   
    @DeleteMapping("departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")   Long departmentId)
    {
        departmentService.deleteDepartmentById(
            departmentId);
        return "Deleted Successfully";
    }

}
