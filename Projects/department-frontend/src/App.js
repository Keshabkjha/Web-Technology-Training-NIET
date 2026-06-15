import logo from './logo.svg';
import './App.css';
import React from 'react';
import DepartmentList from './DepartmentList.js';
import AddDepartmentForm from './AddDepartmentForm.js';


const App = () => {
  return (
      <div>
          <h1>Department Management</h1>
          <AddDepartmentForm />
          <DepartmentList />
      </div>
  );
};

export default App;

