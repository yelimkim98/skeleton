package personal.yerim.skeleton.api.presentation;

import java.time.ZonedDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import personal.yerim.skeleton.api.application.TestQueryService;
import personal.yerim.skeleton.api.presentation.dto.TestResponse;
import personal.yerim.skeleton.core.application.service.dto.CursorCreatedAtPageRequest;
import personal.yerim.skeleton.core.application.service.dto.CursorPageResult;

@RestController
@RequiredArgsConstructor
public class TestQueryController {

  private final TestQueryService testQueryService;

  @GetMapping("/api/v1/tests")
  public ResponseEntity<CursorPageResult<TestResponse>> getTestResponses(
      @RequestParam(required = false) ZonedDateTime lastCreatedAt,
      @RequestParam(required = false) Long lastId,
      @RequestParam(defaultValue = "20") int pageSize
  ) {
    CursorCreatedAtPageRequest request = CursorCreatedAtPageRequest.builder()
        .lastCreatedAt(lastCreatedAt)
        .lastId(lastId)
        .pageSize(pageSize)
        .build();
    return ResponseEntity.ok()
        .body(testQueryService.getPageInCreatedOrder(request));
  }
}
