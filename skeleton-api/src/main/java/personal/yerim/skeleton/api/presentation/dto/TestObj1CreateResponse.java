package personal.yerim.skeleton.api.presentation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class TestObj1CreateResponse {

  private final Long id;
}