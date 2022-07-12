package com.example.spring2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.example.spring2.entity.EmployeeEntity;
import com.example.spring2.model.EmployeeModel;
import com.example.spring2.model.Response;
import com.example.spring2.service.EmployeeDAOInterface;
import com.example.spring2.util.FileUpload;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	@Autowired
	EmployeeDAOInterface empDao;
	
	@Autowired
	FileUpload fileUpload;
	
	@GetMapping("hello")
	public String getHello() {
		return "Hello from Server";
	}
	
	@PostMapping("add-employee")
	public EmployeeEntity addEmployee(@RequestBody EmployeeModel emp) {
		EmployeeEntity insertedEmployee = empDao.createEmployee(emp);
		return insertedEmployee;
	}
	@GetMapping("view-all")
	public List<EmployeeEntity> viewAll() {
		return empDao.findAllEmployee();
	}
	
	@DeleteMapping("delete-by-id")
	public Response deleteById(@RequestParam Integer id) {
		Response res = new Response();
		res.setMessage(empDao.deleteEmployee(id));
		return res;
		
	}
	
	@PutMapping("update-by-id")
	public EmployeeEntity updateById(@RequestBody EmployeeEntity employee) {
		return empDao.updateEmployee(employee);
	}
	
	@GetMapping("view-by-name")
	public List<EmployeeEntity> viewByName(@RequestParam String name){
		return empDao.findByName(name);
	}
	
	@GetMapping("view-one-by-name")
	public EmployeeEntity viewOneByName(@RequestParam String name){
		return empDao.findOneByName(name);
	}
	
	@GetMapping("sorted-by-name")
	public List<EmployeeEntity> sortedByName(){
		return empDao.findAllSortedByName();
	}
	
	@GetMapping("get-name-by-initials")
	public List<EmployeeEntity> getNameByInitials(@RequestParam String initials){
		return empDao.findAllByNameStartsWith(initials);
	}
	
	@GetMapping("get-name-by-ending")
	public List<EmployeeEntity> getNameByEnding(@RequestParam String ending){
		return empDao.findAllByNameEndsWith(ending);
	}
	@GetMapping("get-name-by-mid")
	public List<EmployeeEntity> getNameByMid(@RequestParam String name){
		return empDao.findByNameContainingIgnoreCase(name);
	}
	@PostMapping("add-employee-with-file")
	public EmployeeEntity addEmployeeWithFile(@RequestParam("file") MultipartFile file,EmployeeModel employee){
		fileUpload.uploadFile(file);
		employee.setImage("http://localhost:8080/images/"+file.getOriginalFilename());
		return empDao.createEmployee(employee);
	}
	// @PostMapping("update-employee-with-image")
	// public EmployeeEntity updateEmployeeWithFile(@RequestParam("file") MultipartFile file,EmployeeModel employee){
	// 	// fileUpload.uploadFile(file);
	// 	// employee.setImage(file.getOriginalFilename());
	// 	// return empDao.createEmployee(employee);

	// 	// if(file.getOriginalFilename().equals("dummy.txt")){

	// 	// }
	// }
}
