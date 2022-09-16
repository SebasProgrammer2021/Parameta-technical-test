package parametatest.springboot.repository.utils;

import parametatest.springboot.repository.Constants;

import java.time.LocalDate;
import java.time.Period;


public class EmployeeUtils {
    public Boolean isAdult(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        int calculatedAge = Period.between(birthDate, currentDate).getYears();

        return calculatedAge > Constants.ADULT_AGE;
    }

    public String getEmployeeAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        Period employeeAge = Period.between(birthDate, currentDate);

        return employeeAge.getYears() + "," + employeeAge.getMonths() + "," + employeeAge.getDays();
    }

    public String getAffiliationTime(LocalDate affiliationDate) {
        LocalDate currentDate = LocalDate.now();
        Period affiliationTime = Period.between(affiliationDate, currentDate);

        return affiliationTime.getYears() + " years " + affiliationTime.getMonths() + " months";
    }

}


