package nal.resful.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView create(Model model, @RequestBody Map<String, String> body) throws Exception{
		
        String title = body.get("name");
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(body.get("startdate"));
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(body.get("enddate"));  
        String status = body.get("status");
        try {
        	 workingRespository.save(new TaskWorking(title, startDate,endDate,status));
        }catch(Exception ex) {
        	 
        }
       
        List<TaskWorking> alltaskworking = workingRespository.findAll();
        ModelAndView mv = new ModelAndView("redirect:/index.html");
        mv.getModel().put("workings", alltaskworking);
        return mv;
    }
	
	@PutMapping("/work/update/{id}")
    public TaskWorking update(@PathVariable String id, @RequestBody Map<String, String> body) throws Exception{
        int workId = Integer.parseInt(id);
        
        TaskWorking working = workingRespository.findOne(workId);
        working.setName(body.get("name"));
        Date startdate = new SimpleDateFormat("yyyy-MM-dd").parse(body.get("startdate"));
        Date enddate = new SimpleDateFormat("yyyy-MM-dd").parse(body.get("enddate"));  
        working.setStartdate(startdate);
        working.setEnddate(enddate);
        working.setStatus(body.get("status"));
        return workingRespository.save(working);
    }

    @DeleteMapping("work/delete/{id}")
    public ModelAndView delete(Model model, @PathVariable String id){
        int workId = Integer.parseInt(id);
        workingRespository.delete(workId);
        
        List<TaskWorking> alltaskworking = workingRespository.findAll();
        ModelAndView mv = new ModelAndView("redirect:/index.html");
        mv.getModel().put("workings", alltaskworking);
        return mv;
    }
}
