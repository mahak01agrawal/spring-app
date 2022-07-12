package com.example.spring2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.spring2.entity.EmployeeEntity;
import com.example.spring2.model.EmployeeModel;
import com.example.spring2.repository.EmployeeRepository;
@Service
public class EmployeeDAO implements EmployeeDAOInterface{
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public EmployeeEntity createEmployee(EmployeeModel emp) {
		EmployeeEntity employee = new EmployeeEntity();
		employee.setName(emp.getName());
		employee.setEmail(emp.getEmail());
		employee.setDepartment(emp.getDepartment());
		employee.setSalary(emp.getSalary());
		employee.setPassword(emp.getPassword());
		employee.setImage(emp.getImage());		
		long pack = emp.getSalary() * 12;
		employee.setPack(pack);
		employee.setIsVerified(false);
		employeeRepository.save(employee);
		return employee;
	}
	@Override
	public List<EmployeeEntity> findAllEmployee() {
		return (List<EmployeeEntity>)employeeRepository.findAll();
	}
	@Override
	public String deleteEmployee(Integer id) {
		try {
			employeeRepository.deleteById(id);
			return "Record Deleted";
		}catch(Exception e) {
			System.out.println(e);
			return "Record not found or already already";
		}
	}
	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity emp) {
		EmployeeEntity updated =  employeeRepository.findById(emp.getId()).orElse(null);
		if(updated == null) {
			return updated;
		}
		updated.setName(emp.getName());
		updated.setEmail(emp.getEmail());
		updated.setPassword(emp.getPassword());
		updated.setSalary(emp.getSalary());
		Long pack = emp.getSalary() * 12l;
		updated.setPack(pack);
		updated.setDepartment(emp.getDepartment());
		updated.setImage(emp.getImage());
		employeeRepository.save(updated);
		return updated;
	}
	@Override
	public List<EmployeeEntity> findByName(String name) {
		return employeeRepository.findAllByName(name);
	}
	public EmployeeEntity findOneByName(String name) {
		return employeeRepository.findByName(name);
	}
	public List<EmployeeEntity> findAllSortedByName(){
		return employeeRepository.findByOrderByName();
	}
	public List<EmployeeEntity> findAllByNameStartsWith(String initials){
		return employeeRepository.findAllByNameStartsWith(initials);
	}
	public List<EmployeeEntity> findAllByNameEndsWith(String ending){
		return employeeRepository.findAllByNameEndsWith(ending);
	}
	public List<EmployeeEntity> findByNameContainingIgnoreCase(String name){
		return employeeRepository.findByNameContainingIgnoreCase(name);
	}
}