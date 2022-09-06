package pl.alski.cruddemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.alski.cruddemo.service.EmployeeService;
import pl.alski.cruddemo.entity.Employee;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    //inject employee dao (using Costructor Injection)
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
       this.employeeService =employeeService;
    }

    //expose "/employees" to return the list of all employees

    @GetMapping("/employees")
    public List<Employee> getCustomers() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee==null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //just in case they pass an ID in JSON, set id to 0
        // this enables createOrUpdate by hibernate
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }
    @PutMapping("/employees")
        public Employee updateEmployee(@RequestBody Employee theEmployee){
        //Employee comes to method as JSON in requestBody
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
        public String deleteEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee==null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
            employeeService.deleteById(employeeId);
            return "Deleted employee id- "+employeeId;
        }

    }

