package personal.yerim.skeleton.api.presentation.dto;

import java.time.ZonedDateTime;
import lombok.Builder;

@Builder
public record TestResponse(Long id, String testData, ZonedDateTime createdAt) {

}
