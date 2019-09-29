package nal.resful.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import nal.resful.model.TaskWorking;
import nal.resful.model.entity.WorkingRepository;

@Controller
public class WorkingController {
	
	@Autowired
	WorkingRepository workingRespository;
	
	@GetMapping({"/","/work"})
    public String getAllTaskWorking(Model model){
		List<TaskWorking> alltaskworking = workingRespository.findAll();
		model.addAttribute("workings",alltaskworking);
		return "index";
    }
	
	@PostMapping("/work/add")
    public String createTaskWorking(Model model, @RequestBody Map<String, String> body) throws Exception{
		
        String title = body.get("name");
        LocalDate startDate = LocalDate.parse(body.get("startdate"));
        LocalDate endDate = LocalDate.parse(body.get("enddate"));  
        String status = body.get("status");
        try {
        	 workingRespository.save(new TaskWorking(title, startDate,endDate,status));
        }catch(Exception ex) {
        	 
        }
       
        return "index";
    }
	
	@PutMapping("/work/update/{id}")
    public String updateTaskWorking(Model model,@PathVariable String id, @RequestBody Map<String, String> body) throws Exception{
        int workId = Integer.parseInt(id);
        
        Optional<TaskWorking> optionWorking = workingRespository.findById(workId);
        if(optionWorking.isPresent()) {
        	TaskWorking working = optionWorking.get();
        	working.setName(body.get("name"));
            LocalDate startdate = LocalDate.parse(body.get("startdate"));
            LocalDate enddate = LocalDate.parse(body.get("enddate"));  
            working.setStartdate(startdate);
            working.setEnddate(enddate);
            working.setStatus(body.get("status"));
            workingRespository.save(working);
        }
        
        return "index";
    }

    @DeleteMapping("work/delete/{id}")
    public String deleteTaskWorking(Model model, @PathVariable String id){
        int workId = Integer.parseInt(id);
        workingRespository.deleteById(workId);
        
        return "index";
    }
}
