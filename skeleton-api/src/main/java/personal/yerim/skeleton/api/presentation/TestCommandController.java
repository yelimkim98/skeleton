package personal.yerim.skeleton.api.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import personal.yerim.skeleton.api.application.TestCommandService;
import personal.yerim.skeleton.api.presentation.dto.TestObj1CreateResponse;
import personal.yerim.skeleton.core.application.service.dto.TestObj1CreateDto;

@RestController
@RequiredArgsConstructor
public class TestCommandController {

  private final TestCommandService service;

  @PostMapping("/api/v1/test")
  public ResponseEntity<TestObj1CreateResponse> createTestObj1(
      @RequestBody TestObj1CreateDto request
  ) {
    long generatedId = service.createTestObj1(request);
    return ResponseEntity.ok(TestObj1CreateResponse.builder()
        .id(generatedId)
        .build());
  }
}
