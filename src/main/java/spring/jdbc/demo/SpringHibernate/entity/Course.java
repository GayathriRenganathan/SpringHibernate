package spring.jdbc.demo.SpringHibernate.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(value= {
		@NamedQuery(name = "find_all_course",query="select c from Course c"),
		@NamedQuery(name = "find_by_custom_name", query = "select c from Course c where name like '%JPA'")	
})

public class Course {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	@UpdateTimestamp
	private LocalDateTime lastUpdateDate;
	@CreationTimestamp
	private LocalDateTime createdDate;
	protected Course() {
		super();
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

	
	
	
}
