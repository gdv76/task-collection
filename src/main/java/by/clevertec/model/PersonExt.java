package by.clevertec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PersonExt implements Comparable<PersonExt> {
    private String builder;
    private Person person;


    @Override
    public int compareTo(PersonExt personExt) {
        int personAge = Period.between(personExt.getPerson().getDateOfBirth(), LocalDate.now()).getYears();
        int thisPersonAge = Period.between(this.getPerson().getDateOfBirth(), LocalDate.now()).getYears();

        if (personExt.getBuilder().equals("Hospital") || "Hospital".equals(this.getBuilder())) {
            if (personExt.getBuilder().equals("Hospital") && !this.getBuilder().equals("Hospital")) {
                return 1;
            }
            if (!personExt.getBuilder().equals("Hospital") && this.getBuilder().equals("Hospital")) {
                return -1;
            }
        } else {
            if ((personAge < 18 || personAge > 65) && thisPersonAge >= 18 && thisPersonAge <= 65 ){
                return 1;
            }
            if ((thisPersonAge < 18 || thisPersonAge > 65) && personAge >= 18 && personAge <= 65 ){
                return -1;
            }
        }
        return 0;
    }

}
