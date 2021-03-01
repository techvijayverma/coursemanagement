package org.cdac.service;

import java.util.ArrayList;
import java.util.List;

import org.cdac.DTO.CourseDTO;
import org.cdac.entity.Courses;
import org.cdac.repositories.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

@Autowired
CourseRepository courseRepo;
	
	@Override
	public boolean addCourse(CourseDTO courseDTO) {
		Courses objCourse=new Courses();
		BeanUtils.copyProperties(courseDTO,objCourse);
		courseRepo.save(objCourse);
		return true;
	}

	@Override
	public List<CourseDTO> listCourse() {
		
		List<Courses> courseList=courseRepo.findAll();
		List<CourseDTO> objList=new ArrayList<>();
		for(Courses objCourse:courseList)
		{
			CourseDTO objDTO=new CourseDTO();
			BeanUtils.copyProperties(objCourse,objDTO);
			objList.add(objDTO);
			
		}
		
		return objList;
	}
	
	public CourseDTO findByCourseName(int courseId)
	{
		CourseDTO objDTO=new CourseDTO();
		Courses objCourse=courseRepo.getOne(courseId);
		BeanUtils.copyProperties(objCourse,objDTO);
		return objDTO;
	}

	@Override
	public boolean deleteCourse(int courseId) {
		
		CourseDTO objDTO=findByCourseName(courseId);
		Courses objCourse=new Courses();
		BeanUtils.copyProperties(objDTO,objCourse);
		courseRepo.delete(objCourse);
		return true;
	}

}
