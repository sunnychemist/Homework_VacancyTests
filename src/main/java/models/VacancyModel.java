package models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class VacancyModel {

    private String searchQuery;
    private String title;
    private String city;
    private String companyName;


    public static VacancyModel build() {
        return new VacancyModel()
                .setSearchQuery("Тестировщик")
                .setTitle("QA")
                .setCity("Москва")
                .setCompanyName("Работа.ру");
    }
}
