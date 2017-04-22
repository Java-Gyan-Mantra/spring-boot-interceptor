package com.spring.boot.curd.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.curd.app.dao.EMSDao;
import com.spring.boot.curd.app.exception.EMSException;
import com.spring.boot.curd.app.pojo.Employee;
import com.spring.boot.curd.app.pojo.Response;

@Service
public class EMSService {
	@Autowired(required = true)
	private EMSDao dao;

	public Response add(Employee e) throws EMSException {
		Response response;
		if (e != null) {
			dao.save(e);
			response = new Response(true, "Record Inserted.");
		} else {
			throw new EMSException("Service Gateway Failed");
		}

		return response;
	}

	public List<Employee> getAllEmployee() {
		return (List<Employee>) dao.findAll();
	}

	public Employee findEmployeeById(int id) throws EMSException {
		return dao.findOne(id);
	}

	public Response deleteEmployee(int id) throws EMSException {
		if (id != 0) {
			dao.delete(id);
			return new Response(true, "Record Deleted.");
		} else {
			throw new EMSException("Service Gateway Failed");
		}
	}

	// Update i am not writing here it seems to same as Save as per Derby
	// Embaded DB
}
