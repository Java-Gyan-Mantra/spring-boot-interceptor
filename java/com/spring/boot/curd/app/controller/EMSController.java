package com.spring.boot.curd.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.curd.app.exception.EMSException;
import com.spring.boot.curd.app.pojo.Employee;
import com.spring.boot.curd.app.pojo.Response;
import com.spring.boot.curd.app.service.EMSService;

/**
 * @author BASANTA We need to write logger.error(); in each catch block but here
 *         for console print i used this info statement
 */
@RestController
@RequestMapping(value = "/EMS")
@EnableAutoConfiguration
public class EMSController {
	@Autowired(required = true)
	private EMSService service;

	private Logger logger = LoggerFactory.getLogger(EMSController.class);

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Response addEmployee(@RequestBody Employee e) {
		Response response;
		try {
			response = service.add(e);
		} catch (EMSException exception) {
			response = new Response(false, exception.getLocalizedMessage());
			logger.info("Error while Insertion : " + response);

		}
		return response;
	}

	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
	public List<Employee> getAllEmployee() {
		return service.getAllEmployee();
	}

	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") int id) throws EMSException {
		return service.findEmployeeById(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Response deleteEmployee(@PathVariable("id") int id) {
		Response response;
		try {
			response = service.deleteEmployee(id);
		} catch (EMSException exception) {
			response = new Response(false, exception.getLocalizedMessage());
			logger.info("Error while Delet : " + response);

		}
		return response;
	}
}
