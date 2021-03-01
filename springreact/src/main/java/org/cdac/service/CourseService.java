package org.cdac.service;

import java.util.List;

import org.cdac.DTO.CourseDTO;

public interface CourseService {
	
		public boolean addCourse(CourseDTO courseDTO);
		public List<CourseDTO> listCourse();
		public boolean deleteCourse(int courseId);
		

}
