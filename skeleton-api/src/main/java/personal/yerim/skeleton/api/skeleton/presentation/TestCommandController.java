package personal.yerim.skeleton.api.skeleton.presentation;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.yerim.skeleton.api.skeleton.application.TestCommandService;
import personal.yerim.skeleton.api.skeleton.presentation.dto.TestObj1CreateResponse;
import personal.yerim.skeleton.core.skeleton.application.dto.TestObj1CreateDto;

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
    System.out.println("## tester : " + tester);    // log 로 바꿔볼것
    long generatedId = service.createTestObj1(request);
    return ResponseEntity.ok(TestObj1CreateResponse.builder()
        .id(generatedId)
        .build());
  }
}
