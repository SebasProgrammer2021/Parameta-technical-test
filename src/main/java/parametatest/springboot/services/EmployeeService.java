package parametatest.springboot.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parametatest.springboot.model.Employee;
import parametatest.springboot.repository.EmployeeRepository;
import parametatest.springboot.repository.utils.EmployeeUtils;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EmployeeService {
    EmployeeUtils employeeUtils = new EmployeeUtils();

    @Autowired
    private EmployeeRepository employeeRepository;


    public JSONObject saveEmployee(Employee employee) {
        if (employee.getIdNumber().equals("") || employee.getBirthDate().toString().equals("") || employee.getIdType().equals("") || employee.getName().equals("") || employee.getLastName().equals("") || employee.getPosition().equals("") || employee.getSalary() < 0 || employee.getAffiliationDate().toString().equals("")) {
            return null;
        } else if (!employeeUtils.isAdult(employee.getBirthDate())) {
            return null;
        }

        Employee savedEmployee = employeeRepository.save(employee);

        JSONObject employeeObject = new JSONObject(savedEmployee);
        employeeObject.put("affiliationTime", employeeUtils.getAffiliationTime(employee.getAffiliationDate()));
        employeeObject.put("employeeAge", employeeUtils.getEmployeeAge(employee.getBirthDate()));

        return employeeObject;
    }
}
