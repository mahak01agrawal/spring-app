package com.example.spring2.service;

import java.util.List;

import com.example.spring2.entity.EmployeeEntity;
import com.example.spring2.model.EmployeeModel;

public interface EmployeeDAOInterface {
	public EmployeeEntity createEmployee(EmployeeModel emp);
	public List<EmployeeEntity> findAllEmployee();
	public String deleteEmployee(Integer id);
	public EmployeeEntity updateEmployee(EmployeeEntity emp);
	public List<EmployeeEntity> findByName(String name);
	public EmployeeEntity findOneByName(String name);
	public List<EmployeeEntity> findAllSortedByName();
	public List<EmployeeEntity> findAllByNameStartsWith(String initials);
	public List<EmployeeEntity> findAllByNameEndsWith(String ending);
	public List<EmployeeEntity> findByNameContainingIgnoreCase(String name);
}
