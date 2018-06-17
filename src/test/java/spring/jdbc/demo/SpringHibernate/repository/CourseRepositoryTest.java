package spring.jdbc.demo.SpringHibernate.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em; 
	
	@Test
	public void queryBasic() {
		List resultList = em.createNamedQuery("find_all_course").getResultList();
		logger.info("BASIC :select c from Course c -> {}",resultList);
	}
	
	@Test
	public void queryTyped() {
		List<Course> resultList = em.createQuery("select c from Course c",Course.class).getResultList();
		logger.info("TYPED: select c from Course c -> {}",resultList);
	}
	
	@Test
	public void queryWhereClause() {
		List<Course> resultList = 
				em.createNamedQuery("find_by_custom_name",Course.class).getResultList();
		logger.info("select c from Course c WHERE NAME LIKE %JPA -> {}",resultList);
	}
	@Test
	public void nativeQuery() {
		List<Course> resultList = 
				em.createNativeQuery("select* from course",Course.class).getResultList();
		logger.info("Native query basic -> {}",resultList);
	}
	@Test
	public void nativeQueryWithParam() {
		Query createNativeQuery = 
				em.createNativeQuery("select* from course where id = ?",Course.class);
		createNativeQuery.setParameter(1, 10001);
		List resultList = createNativeQuery.getResultList();
		logger.info("Native query with parameters -> {}",resultList);
	}
	
	@Test
	public void nativeQueryWithNamedParam() {
		Query createNativeQuery = 
				em.createNativeQuery("select* from course where id = :id",Course.class);
		createNativeQuery.setParameter("id", 10001);
		List resultList = createNativeQuery.getResultList();
		logger.info("Native query with named parameters -> {}",resultList);
	}
}
