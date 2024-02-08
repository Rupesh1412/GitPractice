package com.cjc.main.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Employee;
import com.cjc.main.repository.HomeRepository;
import com.cjc.main.servicei.HomeServiceInterface;

@Service
public class Homeserviceimpl implements HomeServiceInterface {
@Autowired
	HomeRepository hr;
	@Override
	public void saveData(Employee e) {
		hr.save(e);
	}
	@Override
	public List<Employee> logincheck(String u, String p) {
		List<Employee>list=hr.findAllByUsernameAndPassword(u, p);
		return list;
	}
	@Override
	public Iterable displayAllData() {
		return hr.findAll();
	}
	@Override
	public void deleteEmployee(int id) {
            hr.deleteById(id);
		
	}
	@Override
	public void editEmployee(int id,String name,String address) {
		hr.editNameAndAddress(id, name, address);
		
	}

}
