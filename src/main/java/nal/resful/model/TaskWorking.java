package nal.resful.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "taskworking")
public class TaskWorking {

	
	private Integer id;
	
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name="startdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startdate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="enddate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate enddate;
	
	private String status;
	
	public TaskWorking() {};
	
	public TaskWorking(String name, LocalDate startdate, LocalDate enddate, String status) {
		this.setName(name);
		this.setStartdate(startdate);
		this.setEnddate(enddate);
		this.setStatus(status);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	
	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
