package com.spring.boot.curd.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.boot.curd.app.pojo.Employee;

@RepositoryRestResource
public interface EMSDao extends CrudRepository<Employee, Integer> {

	/**
	 * @author BASANTA Every operation Related to Primery_key only possible so
	 *         it's not recommended to use in Real time for business purpose,
	 *         But the best use of this approach is for our JUNIT test cases
	 *         ,Normally when we are running JUNIT it hits the controller then
	 *         Service then our own DB so think why this test data i will save
	 *         in my DB ? why not i will save it in embedded custom DB provided
	 *         by Framework itself
	 * 
	 * @May be some appropriate use case will be there , but this is my view
	 *      what i analyze
	 */

}
