package parametatest.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EmployeeService")
public class Employee {
    @Column(name = "affiliation_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate affiliationDate;
//    private LocalDate affiliationTime;

    @Column(name = "birth_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(name = "id_number", nullable = false)
    private String idNumber;

    @Column(name = "id_type", nullable = false)
    private String idType;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "salary", nullable = false)
    private double salary;

}
