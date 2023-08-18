import axios from 'axios';

const CREDIT_API_BASE_URL = "http://pbwmchallenge7.conygre.com:8080/api/";

class CreditService {

    getEmployees(){
        return axios.get(CREDIT_API_BASE_URL + '');
    }

    createEmployee(employee){
        return axios.post(CREDIT_API_BASE_URL, employee);
    }

    getEmployeeById(employeeId){
        return axios.get(CREDIT_API_BASE_URL + '/' + employeeId);
    }

    updateEmployee(employee, employeeId){
        return axios.put(CREDIT_API_BASE_URL + '/' + employeeId, employee);
    }

    deleteEmployee(employeeId){
        return axios.delete(CREDIT_API_BASE_URL + '/' + employeeId);
    }
}

export default new CreditService()
