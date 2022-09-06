package pl.alski.cruddemo.DAO.replacedBySpringDataJpa;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.alski.cruddemo.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    //define the fields for entitymanager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getCustomers() {

        //get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query
        Query<Employee> theQuery =
                currentSession.createQuery("from Employee", Employee.class);

        //execute query and get results list
        List<Employee> employees = theQuery.getResultList();

        //return the results

        return employees;
    }

    @Override
    public Employee getEmployee(int theId) {

        //get the Current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //get the Employee
        Employee theEmployee = currentSession.get(Employee.class, theId);

        //return theEmployee

        return theEmployee;
    }

    @Override
    public void saveEmployee(Employee theEmployee) {

        //get the Current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //save the Employee

        currentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        //get the Current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //delete object with primary key
//        Query theQuery= currentSession.createQuery(
//                "delete from Employee where id=:employeeId", Employee.class);
//        theQuery.setParameter("employeeId", theId);
//        theQuery.executeUpdate();

        //the other way
        Employee theEmployee=currentSession.get(Employee.class, theId);
        currentSession.delete(theEmployee);


    }
}
