package by.clevertec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AnimalZoo {
    private Integer indexZoo = 0;
    private static Integer indexAnimal = 0;
    private Animal animal;

    public static Integer getIndexAnimal() {
        return AnimalZoo.indexAnimal;
    }

    public Integer getIndexZoo() {
        return indexZoo;
    }

    public void setIndexZoo(Integer indexZoo) {
        this.indexZoo = indexZoo;
    }

    public AnimalZoo(Animal animal, Integer indexZoo) {
        this.animal = animal;
        this.indexZoo = indexZoo;
        AnimalZoo.indexAnimal++;
    }

}
