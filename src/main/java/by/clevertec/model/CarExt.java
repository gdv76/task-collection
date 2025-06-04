package by.clevertec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CarExt {
    private String country;
    private Car car;

    public CarExt(Car car) {
        this.car = car;
        if (car.getCarMake().equals("Jaguar") || car.getColor().equals("White")) {
            this.country = "Туркменистан";
        } else if (car.getMass() <= 1500 &&
                  (car.getCarMake().equals("BMW") || car.getCarMake().equals("Lexus") ||
                   car.getCarMake().equals("Chrysler") || car.getCarMake().equals("Toyota"))) {
            this.country = "Узбекистан";
        } else if (car.getColor().equals("Black") && car.getMass() > 4000 ||
                  (car.getCarMake().equals("GMC") || car.getCarMake().equals("Dodge") ))  {
            this.country = "Казахстан";
        } else if (car.getReleaseYear() < 1982 ||
                   car.getCarModel().equals("Civic") ||
                   car.getCarModel().equals("Cherokee")) {
            this.country = "Кыргызстан";
        } else if (!car.getColor().equals("Yellow") && !car.getColor().equals("Red") &&
                   !car.getColor().equals("Green") && !car.getColor().equals("Blue") || car.getPrice() > 40000) {
            this.country = "Россия";
        } else if (car.getVin().contains("59")) {
            this.country = "Монголия";
        }
    }
}
