package spring.jdbc.demo.SpringHibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import spring.jdbc.demo.SpringHibernate.entity.Course;
//import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {

//	@PersistenceContext
	@Autowired
	EntityManager entityManager;
	
	public Course findByid(int id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(int id) {
		Course course = findByid(id);
		entityManager.remove(course);
	}
	
	public Course merge(Course course) {
		return entityManager.merge(course);
	}
	
	public void playWithEm() {
		Course course1 = findByid(10001);
		course1.setName("Spring JPA - Updated");
		merge(course1);
		
	}
}
