package com.greatlearning.debateevent.workflow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.debateevent.dataservice.StudentDataService;
import com.greatlearning.debateevent.domain.entities.Student;

@Controller
@RequestMapping("/students")
public class StudentDebateEventController {
	
	//Autowire Data Service class
	@Autowired
	private StudentDataService studentDataService;

	@RequestMapping("/list")
	public String listStudents(Model model) {
		List<Student> students = studentDataService.findAll();
		model.addAttribute("students", students);
		return "StudentList";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Student student = new Student();
		theModel.addAttribute("student", student);

		// send over to our form
		return "StudentEnrolment";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {

		// Get the student from the service
		Student std = studentDataService.findById(theId);

		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("student", std);

		// send over to our form
		return "StudentEnrolment";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		System.out.println(id);
		Student student;
		
		//Update if existing student
		if (id != 0) {
			student = studentDataService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		} else
			//Create new student if not existing
			student = new Student(name, department, country);
		
		// Save the Student
		studentDataService.persist(student);

		// Use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int theId) {

		// Delete the student
		studentDataService.deleteById(theId);

		return "redirect:/students/list";

	}
}
