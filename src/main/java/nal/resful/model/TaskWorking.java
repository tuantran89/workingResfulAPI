package nal.resful.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "taskworking")
public class TaskWorking {

	
	private Integer id;
	
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name="startdate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startdate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="enddate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date enddate;
	
	private String status;
	
	public TaskWorking() {};
	
	public TaskWorking(String name, Date startdate, Date enddate, String status) {
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

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	
	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
