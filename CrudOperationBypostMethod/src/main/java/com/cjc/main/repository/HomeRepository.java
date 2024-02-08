package com.cjc.main.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Employee;

@Repository
public interface HomeRepository extends CrudRepository<Employee, Integer>{
	   public List<Employee> findAllByUsernameAndPassword(String u,String p);
	   @Modifying
	   @Transactional
	   @Query("update Employee set  name=:name, address=:address where id=:id")
	   public void editNameAndAddress(int id,String name,String address);
}
