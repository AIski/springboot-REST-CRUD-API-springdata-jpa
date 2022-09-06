package pl.alski.cruddemo.DAO.replacedBySpringDataJpa;

import pl.alski.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getCustomers();
    public Employee getEmployee(int theId);
    public void saveEmployee(Employee theEmployee);
    public void deleteById(int theId);
}
