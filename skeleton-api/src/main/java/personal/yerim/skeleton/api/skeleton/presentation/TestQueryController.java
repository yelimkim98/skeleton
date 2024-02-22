package personal.yerim.skeleton.api.skeleton.presentation;

import io.swagger.v3.oas.annotations.Parameter;
import java.time.ZonedDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import personal.yerim.skeleton.api.skeleton.application.TestQueryService;
import personal.yerim.skeleton.api.skeleton.presentation.dto.TestResponse;
import personal.yerim.skeleton.core.skeleton.application.WebclientTestService;
import personal.yerim.skeleton.core.skeleton.application.dto.CursorCreatedAtPageRequest;
import personal.yerim.skeleton.core.skeleton.application.dto.CursorPageResult;
import personal.yerim.skeleton.core.skeleton.application.dto.WebClientTestResponse;

@RestController
@RequestMapping("/api/v1/skeleton")
@RequiredArgsConstructor
public class TestQueryController {

  private final TestQueryService testQueryService;
  private final WebclientTestService webclientTestService;

  @GetMapping("/tests")
  public ResponseEntity<CursorPageResult<TestResponse>> test(
      @RequestHeader @Parameter(example = "kiel0103@naver.com") String tester,
      @RequestParam(required = false) ZonedDateTime lastCreatedAt,
      @RequestParam(required = false) Long lastId,
      @RequestParam(defaultValue = "20") int pageSize
  ) {
    System.out.println("## tester : " + tester);
    CursorCreatedAtPageRequest request = CursorCreatedAtPageRequest.builder()
        .lastCreatedAt(lastCreatedAt)
        .lastId(lastId)
        .pageSize(pageSize)
        .build();
    return ResponseEntity.ok()
        .body(testQueryService.getPageInCreatedOrder(request));
  }

  @GetMapping("/test-web-client")
  public ResponseEntity<CursorPageResult<WebClientTestResponse>> testWebClient() {
    return ResponseEntity.ok(webclientTestService.callGetTwice());
  }
}
