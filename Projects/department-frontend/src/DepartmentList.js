//DepartmentList.js
import React, { useEffect, useState } from 'react';
import apiService from './apiService';
import './DepartmentList.css';


const DepartmentList = () => {
    const [departments, setDepartments] = useState([]);

    useEffect(() => {
        apiService.getDepartments()
            .then(response => {
                setDepartments(response.data);
            })
            .catch(error => {
                console.error("There was an error retrieving the department list!", error);
            });
    }, []);
    return (
        <div className="department-list-container">
            <h1>Departments</h1>
            <ul className="department-list">
                {departments.map(department => (
                    <li key={department.departmentId}>
                        <span>{department.departmentName}</span>
                        <span>{department.departmentAddress}</span>
                    </li>
                ))}
            </ul>
        </div>
    );
};
export default DepartmentList;