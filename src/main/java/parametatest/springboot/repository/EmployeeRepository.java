package parametatest.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parametatest.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //all crud dddbb methods
}
