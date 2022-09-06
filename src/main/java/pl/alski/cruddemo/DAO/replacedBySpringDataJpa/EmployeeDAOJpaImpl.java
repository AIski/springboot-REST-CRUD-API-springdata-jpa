package pl.alski.cruddemo.DAO.replacedBySpringDataJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.alski.cruddemo.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager   entityManager;

    @Autowired
   public  EmployeeDAOJpaImpl(EntityManager entityManager){
       this.entityManager = entityManager;
   }

    @Override
    public List<Employee> getCustomers() {
        //create a query
        Query theQuery=entityManager.createQuery("from Employee");

        //execute the query and get results list
List<Employee> employees = theQuery.getResultList();
        //return the results
        return employees;
    }

    @Override
    public Employee getEmployee(int theId) {
        //get Employee
        Employee theEmployee=entityManager.find(Employee.class, theId);
        //return employee
        return theEmployee;
    }

    @Override
    public void saveEmployee(Employee theEmployee) {
        //save or update the employee
        //if id==0, then insert/save else update
        Employee dbEmployee= entityManager.merge(theEmployee);
        //update with id from db, so we can get generated id for save/insert
        theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {
        //delete object with primary key
        Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();

    }
}
