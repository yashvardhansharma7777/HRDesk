package com.HRDesk.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.HRDesk.entity.Employee;
import com.HRDesk.entity.Status;
import com.HRDesk.repository.EmployeeRepository;

@Service
public class EmployeeService {
  

  private EmployeeRepository employeeRepository;

  EmployeeService(EmployeeRepository employeeRepository){
      this.employeeRepository = employeeRepository;
  }

  
  public Employee getEmployeeById(Long id){
      Employee employee = employeeRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("employee not found"));

      return employee;

  }


  public void delete(Long id){

     Employee employee = employeeRepository.findById(id)
     .orElseThrow(() -> new RuntimeException("id not present"));

     employeeRepository.delete(employee);
  }


  public Map<String, Object> softDelete(Long id){
 
     Map<String, Object> mpp = new HashMap<>();
     Optional<Employee> op = employeeRepository.findById(id);

     if(op.isPresent()){
          Employee employee = op.get();
          employee.setStatus(Status.DEACTIVE);
          employeeRepository.save(employee);
          mpp.put("Status", "SUCCESS");
          mpp.put("Data", employee);
     }
     else{
      mpp.put("Status", "ERROR");
      mpp.put("Data", null);
     }
      return mpp;
  }
   
  
  public Employee updateNo(Long id, Long phoneNo){

    Employee employee = employeeRepository.findById(id)
     .orElseThrow(() -> new RuntimeException("id not present"));

     employee.setPhoneNo(phoneNo);
    //  employeeRepository.save(employee);
     return employeeRepository.save(employee);
  }


}
