package spring.jdbc.demo.SpringHibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring.jdbc.demo.SpringHibernate.entity.Course;
import spring.jdbc.demo.SpringHibernate.repository.CourseRepository;

@SpringBootApplication
public class SpringHibernateApplication implements CommandLineRunner{

	@Autowired
	private CourseRepository courseRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("Course 10001-> {}",courseRepository.findByid(10001));
			courseRepository.merge(new Course("Machine Learning"));
//			courseRepository.merge(new Course(1,"Machine Learning in Depth"));
			courseRepository.playWithEm();
	}
}
