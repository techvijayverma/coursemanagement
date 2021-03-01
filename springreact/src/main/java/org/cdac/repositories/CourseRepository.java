package org.cdac.repositories;

import org.cdac.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses, Integer> {

}
