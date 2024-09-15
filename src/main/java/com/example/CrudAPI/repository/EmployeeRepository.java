package com.example.CrudAPI.repository;

import com.example.CrudAPI.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel,Long> {
}
