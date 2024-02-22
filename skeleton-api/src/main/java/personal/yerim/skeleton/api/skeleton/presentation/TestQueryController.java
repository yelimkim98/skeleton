package personal.yerim.skeleton.api.skeleton.presentation;

import java.time.ZonedDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import personal.yerim.skeleton.api.skeleton.application.TestQueryService;
import personal.yerim.skeleton.api.skeleton.presentation.dto.TestResponse;
import personal.yerim.skeleton.core.skeleton.application.dto.CursorCreatedAtPageRequest;
import personal.yerim.skeleton.core.skeleton.application.dto.CursorPageResult;

@RestController
@RequestMapping("/api/v1/skeleton")
@RequiredArgsConstructor
public class TestQueryController {

  private final TestQueryService testQueryService;

  @GetMapping("/tests")
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
