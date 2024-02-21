package personal.yerim.skeleton.api.application;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import personal.yerim.skeleton.api.presentation.dto.TestResponse;
import personal.yerim.skeleton.core.application.service.TestObj1Service;
import personal.yerim.skeleton.core.application.service.dto.CursorCreatedAtPageRequest;
import personal.yerim.skeleton.core.application.service.dto.CursorPageResult;
import personal.yerim.skeleton.core.domain.TestObj1;

@Service
@RequiredArgsConstructor
public class TestQueryService {

  private final TestObj1Service testObj1Service;

  public CursorPageResult<TestResponse> getPageInCreatedOrder(CursorCreatedAtPageRequest pageRequest) {
    CursorPageResult<TestObj1> testObj1s = testObj1Service.getPageInCreatedOrder(pageRequest);

    List<TestResponse> results = testObj1s.items().stream()
        .map(testObj1 -> TestResponse.builder()
            .id(testObj1.getId())
            .testData(testObj1.getValue().toPlainString())
            .createdAt(testObj1.getCreatedAt())
            .build())
        .collect(Collectors.toList());

    return new CursorPageResult<>(results,
        testObj1s.lastCreatedAt(), testObj1s.lastId(), testObj1s.pageSize());
  }
}
