package com.example.CrudAPI.controller;


import com.example.CrudAPI.model.EmployeeModel;
import com.example.CrudAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/GetAllEmployee")
    public List<EmployeeModel> GetAllEmployee(){
        return service.GetAllEmployee();
    }
    @GetMapping("GetById/{id}")
    public ResponseEntity<EmployeeModel> GetById(@PathVariable  Long Id){
        EmployeeModel employee=service.GetEmployeeById(Id);
        if(employee!=null){
            return ResponseEntity.ok(employee);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/AddEmployee")
    public ResponseEntity<EmployeeModel> AddEmployee(@RequestBody EmployeeModel model){
        EmployeeModel employee=service.AddEmployee(model);
        if(employee!=null){
            return ResponseEntity.ok(employee);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeModel> UpdateEmployee(@PathVariable Long id,@RequestBody EmployeeModel model){
        EmployeeModel employee=service.UpdateEmployee(id,model);
        if(employee!=null){
            return ResponseEntity.ok(employee);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public void DeleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
    }
}
