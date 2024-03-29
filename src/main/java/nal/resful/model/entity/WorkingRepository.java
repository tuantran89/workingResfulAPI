package nal.resful.model.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nal.resful.model.TaskWorking;

@Repository
public interface WorkingRepository extends JpaRepository<TaskWorking, Integer> {

    
}