package com.greatlearning.debateevent.dataservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.debateevent.domain.entities.Student;

@Service
public interface StudentDataService {

	// Get Info about all Students
	public List<Student> findAll();

	// Find student record by using its id
	public Student findById(int id);

	// Insert and update method
	public void persist(Student student);

	// Delete method
	public void deleteById(int id);

}
