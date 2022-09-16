package parametatest.springboot.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parametatest.springboot.model.Employee;
import parametatest.springboot.services.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) throws Exception {

        try {
            JSONObject employeeCreated = employeeService.saveEmployee(employee);

            if (employeeCreated != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(employeeCreated.toString());
            } else {
                JSONObject objetoJson = new JSONObject();
                objetoJson.put("Codigo error", HttpStatus.BAD_REQUEST.value());
                objetoJson.put("Descripción error", HttpStatus.BAD_REQUEST);
                String jsonString = objetoJson.toString();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
            }

        } catch (Exception err) {
            throw new Exception("error on date format" + err);
        }


    }
}
