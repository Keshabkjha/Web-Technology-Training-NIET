import axios from 'axios';

const API_URL = 'http://localhost:8084/api/departments';

const getDepartments = () => {
    return axios.get(API_URL);
};

const createDepartment = (department) => {
    return axios.post(API_URL, department);
};

const updateDepartment = (id, department) => {
    return axios.put(`${API_URL}/${id}`, department);
};

const deleteDepartment = (id) => {
    return axios.delete(`${API_URL}/${id}`);
};

export default {
    getDepartments,
    createDepartment,
    updateDepartment,
    deleteDepartment,
};

