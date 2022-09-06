package pl.alski.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.alski.cruddemo.DAO.EmployeeRepository;
import pl.alski.cruddemo.entity.Employee;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    //  private EmployeeDAO employeeDAO; // replaced by EmployeeRepository from Spring Data JPA

    private EmployeeRepository employeeRepository;

    //constructor Injection of EmployeeDAO
    @Autowired
//    public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl")EmployeeDAO employeeDAO) {
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
// this.empliyeeDAO = employeeDAO;
        employeeRepository = theEmployeeRepository;
    }


    @Override
//    @Transactional no needed since JpaRepository provides this functionality
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
//    @Transactional no needed since JpaRepository provides this functionality
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theEmployee;
    }

    @Override
    //    @Transactional no needed since JpaRepository provides this functionality
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
//    @Transactional no needed since JpaRepository provides this functionality
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);

    }
}
