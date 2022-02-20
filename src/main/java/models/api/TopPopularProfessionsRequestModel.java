package models.api;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class TopPopularProfessionsRequestModel {
    private Integer region_id;
    private Integer limit;
    private String query;

    public static TopPopularProfessionsRequestModelBuilder newModel() {
        return TopPopularProfessionsRequestModel.builder()
                .region_id(3)
                .limit(3)
                .query("");
    }
}
