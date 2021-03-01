package org.cdac.controllers;

import java.util.List;

import org.cdac.DTO.CourseDTO;
import org.cdac.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping("/addcourse")
	public boolean addCourse(@RequestBody CourseDTO objDTO)
	{
		courseService.addCourse(objDTO);
		return true;
		
	}
	
	@GetMapping("/deletecourse/{cid}")
	public boolean deleteCourse(@PathVariable int cid )
	{
		courseService.deleteCourse(cid);
		return true;
	}
	
	@GetMapping("/listcourse")
	public List<CourseDTO> listCourse()
	{
		return courseService.listCourse();
	}
	

}
