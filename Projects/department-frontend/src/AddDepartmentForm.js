import React, { useState } from 'react';
import apiService from './apiService';

const AddDepartmentForm = () => {
    const [departmentName, setDepartmentName] = useState('');
    const [departmentAddress, setDepartmentAddress] = useState('');
    const [departmentCode, setDepartmentCode] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        const newDepartment = { departmentName, departmentAddress, departmentCode };

        apiService.createDepartment(newDepartment).then(response => {
            console.log("Department added successfully:", response.data);
        }).catch(error => {
            console.error("There was an error adding the department!", error);
        });
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Department Name:</label>
                <input
                    type="text"
                    value={departmentName}
                    onChange={(e) => setDepartmentName(e.target.value)}
                />
            </div>
            <div>
                <label>Department Address:</label>
                <input
                    type="text"
                    value={departmentAddress}
                    onChange={(e) => setDepartmentAddress(e.target.value)}
                />
            </div>
            <div>
                <label>Department Code:</label>
                <input
                    type="text"
                    value={departmentCode}
                    onChange={(e) => setDepartmentCode(e.target.value)}
                />
            </div>
            <button type="submit">Add Department</button>
            </form>
    );
};

export default AddDepartmentForm;
