package by.clevertec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class HouseExt {
    private List<PersonExt> personExtList;
    public HouseExt(House house) {
        personExtList = new ArrayList<>();
        for (Person person: house.getPersonList()) {
            personExtList.add(new PersonExt(house.getBuildingType(),person));
        }
    }
}
