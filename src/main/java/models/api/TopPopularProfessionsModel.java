package models.api;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
public class TopPopularProfessionsModel {
    private TopPopularProfessionsRequestModel request;

    public static TopPopularProfessionsModelBuilder newTopPopularProfessionsModel() {
        return TopPopularProfessionsModel.builder().request(TopPopularProfessionsRequestModel.newModel().build());
    }
}