package models;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

@Data
@Accessors(chain = true)
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class UserModel {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String position;
    private String email;


    public static UserModel build() {
       Faker faker = new Faker(new Locale("ru-RU"));
       return new UserModel()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setBirthday(LocalDate.now().minusYears((new Random().nextInt(30) - 18)))
                .setBirthday(LocalDate.now().minusYears(30))
                .setPosition(faker.job().position())
                .setEmail(new Faker().internet().emailAddress());
    }
}
