package com.example.CrudAPI.service;


import com.example.CrudAPI.model.EmployeeModel;
import com.example.CrudAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeModel> GetAllEmployee(){
        return repository.findAll();
    }

    public EmployeeModel GetEmployeeById(Long Id){
        return repository.findById(Id).orElseThrow();
    }
    public EmployeeModel AddEmployee(EmployeeModel model){
        return repository.save(model);
    }
    public EmployeeModel UpdateEmployee(Long Id,EmployeeModel model){
        EmployeeModel employee=repository.findById(Id).orElseThrow();
        employee.setName(model.getName());
        employee.setJob(model.getJob());
        employee.setSalary(model.getSalary());
        return repository.save(employee);
    }
    public void deleteEmployee(Long Id){
        repository.deleteById(Id);
    }
}
