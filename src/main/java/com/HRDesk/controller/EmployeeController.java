package com.HRDesk.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HRDesk.dto.updateRequestDTO;
import com.HRDesk.entity.Employee;
import com.HRDesk.repository.EmployeeRepository;
import com.HRDesk.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
  
  
  private EmployeeService employeeService;

  EmployeeController(EmployeeService employeeService){
      this.employeeService = employeeService;
  }

  @GetMapping("/{empId}")
  public ResponseEntity<Employee> getEmplyeeById(@PathVariable Long empId ){

     Employee employee = employeeService.getEmployeeById(empId);
     return ResponseEntity.status(HttpStatus.OK).body(employee);
  }
  
  @DeleteMapping("/{empid}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable Long empid){
    employeeService.delete(empid);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/softdelete/{empid}")
  public ResponseEntity<Map<String,Object>> softDelete(@PathVariable Long empid){

      Map<String,Object> mpp = employeeService.softDelete(empid);
       return ResponseEntity.status(HttpStatus.OK).body(mpp);
  }

  @PutMapping("/updatePh/{id}")
  public ResponseEntity<Employee> updatePh(@PathVariable Long id, @RequestBody updateRequestDTO req){

      Employee employee = employeeService.updateNo(id, req.getPhoneNo());
      return ResponseEntity.status(HttpStatus.CREATED).body(employee);
  }

  // @PostMapping("/postEmployee")
  // public ResponseEntity<Employee> postEmployee(@RequestBody updateRequestDTO req){


  // }
}
