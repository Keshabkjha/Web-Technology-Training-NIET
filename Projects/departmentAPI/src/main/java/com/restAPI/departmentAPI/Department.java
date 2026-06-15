package com.restAPI.departmentAPI;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Department class is POJO 
// it represents Model means values
@Entity  // jpa + hibernate anotation to create the table in mysql 
@Data  // annotation of lombak
@NoArgsConstructor  // annotation for creating constructor
@AllArgsConstructor // anotate for constructor
@Builder // design pattern to create objcet
public class Department {
	
	@Id  // primary key in table
    @GeneratedValue // auto_increment
    private Long departmentId;
	
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
    
    @Version private Long version;
    
	public Department() {
		super();
	}
	// NOTE: departmentID is not included 
	// in the constructor
	// becuase there is @GeneratedValue
	// for auto_increament - handle by jpa- mysql
	public Department(String departmentName, String departmentAddress, String departmentCode) {
		super();
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.departmentCode = departmentCode;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(departmentAddress, departmentCode, departmentId, departmentName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(departmentAddress, other.departmentAddress)
				&& Objects.equals(departmentCode, other.departmentCode)
				&& Objects.equals(departmentId, other.departmentId)
				&& Objects.equals(departmentName, other.departmentName);
	}
	public String getDepartmentName() {
		// TODO Auto-generated method stub
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		// TODO Auto-generated method stub
		this.departmentName=departmentName;
		
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	
	public String getDepartmentAddress() {
		return departmentAddress;
	}
	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	

}
