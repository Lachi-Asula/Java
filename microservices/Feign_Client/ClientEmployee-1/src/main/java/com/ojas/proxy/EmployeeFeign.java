package com.ojas.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ojas.model.Employee123;

@FeignClient(name="employee1", url="localhost:9092")
public interface EmployeeFeign {

	@RequestMapping("/emp1/list")
	public List<Employee123> getEmpList();
}
