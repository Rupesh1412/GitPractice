package com.cjc.main.servicei;

import java.util.List;

import com.cjc.main.model.Employee;

public interface HomeServiceInterface {

	public void saveData(Employee e);
	public List<Employee> logincheck(String u,String p);
    public Iterable displayAllData();
    public void deleteEmployee(int id);
    public void editEmployee(int id,String name,String address);
}
