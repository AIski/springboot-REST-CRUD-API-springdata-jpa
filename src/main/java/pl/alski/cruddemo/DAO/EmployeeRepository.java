package pl.alski.cruddemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.alski.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //thats it, SpringData JPA does all the magic
}
