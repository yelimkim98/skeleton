package personal.yerim.skeleton.api.skeleton.presentation;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.yerim.skeleton.api.skeleton.application.TestCommandService;
import personal.yerim.skeleton.api.skeleton.presentation.dto.TestObj1CreateResponse;
import personal.yerim.skeleton.core.skeleton.application.dto.TestObj1CreateDto;

@Slf4j
@RestController
@RequestMapping("/api/v1/skeleton")
@RequiredArgsConstructor
public class TestCommandController {

  private final TestCommandService service;

  @PostMapping("/test")
  public ResponseEntity<TestObj1CreateResponse> createTestObj1(
      @RequestHeader @Parameter(example = "kiel0103@naver.com") String tester,
      @RequestBody TestObj1CreateDto request
  ) {
    log.debug("## tester : {}", tester);
    long generatedId = service.createTestObj1(request);
    return ResponseEntity.ok(TestObj1CreateResponse.builder()
        .id(generatedId)
        .build());
  }
}
