package com.example.spring2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring2.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	public List<EmployeeEntity> findAllByName(String name);
	public EmployeeEntity findByName(String name);
	public List<EmployeeEntity> findByOrderByName();
	public List<EmployeeEntity> findAllByNameStartsWith(String initials);
	public List<EmployeeEntity> findAllByNameEndsWith(String ending);
	public List<EmployeeEntity> findByNameContainingIgnoreCase(String name);
}