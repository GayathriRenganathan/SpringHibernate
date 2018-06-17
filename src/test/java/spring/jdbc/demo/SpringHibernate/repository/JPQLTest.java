package spring.jdbc.demo.SpringHibernate.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import spring.jdbc.demo.SpringHibernate.SpringHibernateApplication;
import spring.jdbc.demo.SpringHibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringHibernateApplication.class)
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void testFindById() {
		Course course = courseRepository.findByid(10001);
		assertEquals("Spring JPA", course.getName());
	}
	
	@Test
	@DirtiesContext
	public void testDeleteById() {
		courseRepository.deleteById(10001);
		assertNull(courseRepository.findByid(10001));
		
	}
	@Test
	@DirtiesContext
	public void testSaveById() {
		Course course = courseRepository.findByid(1);
		course.setName("Machine Learning in Depth");
		courseRepository.merge(course);
		Course course1 = courseRepository.findByid(1);
		assertEquals("Machine Learning in Depth",course1.getName());
		
		
	}
}
