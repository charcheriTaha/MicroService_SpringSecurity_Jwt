package Taha.Jwt.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Task {
public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
public Task(Long id, String taskName) {
		super();
		this.id = id;
		this.taskName = taskName;
	}
@Id @GeneratedValue
private Long id ;
public Task() {
	super();
}
private String taskName ;
}
