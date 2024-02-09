package com.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Employee;
import com.cjc.main.seviceimpl.Homeserviceimpl;

@RestController
public class HomeController {

	@Autowired
	Homeserviceimpl hsi;
	
	@PostMapping("/employee")
	public String create(@RequestBody Employee e) 
	{
		hsi.saveData(e);
		return"Employee created";
	}
	
	@GetMapping("/getData/{u}/{p}")
	public Iterable loginCheck(@PathVariable String u,@PathVariable String p  ) 
	{
			
		Iterable list=hsi.displayAllData();
		if(u.equals("admin")&&p.equals("admin")) {
		
             

                  System.out.println("This is the change");
		return list;
		}
		else {
			
			List<Employee> list1=hsi.logincheck(u, p);
			
			return list1;
		}
	}
	@PutMapping("/editData/{id}")  
	public Employee editEmp(@PathVariable int id,@RequestBody Employee e) 
	{
		System.out.println("update employee"+id);
		System.out.println("Received employee"+e.getId());

		 hsi.saveData(e);
		 return e;
	}
	@DeleteMapping("/delData/{id}")
	public void delEmployee(@PathVariable int id) 
	{
		hsi.deleteEmployee(id);
	}
	@PatchMapping("/updateData/{id}/{name}/{address}")
	public void updateEmp(@PathVariable int id,@PathVariable String name,@PathVariable String address) 
	{
	hsi.editEmployee(id, name, address);
		
	}
	
}
