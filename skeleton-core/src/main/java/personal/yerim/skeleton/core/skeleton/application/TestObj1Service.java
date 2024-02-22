package personal.yerim.skeleton.core.skeleton.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import personal.yerim.skeleton.core.skeleton.application.dto.CursorCreatedAtPageRequest;
import personal.yerim.skeleton.core.skeleton.application.dto.CursorPageResult;
import personal.yerim.skeleton.core.skeleton.application.dto.TestObj1CreateDto;
import personal.yerim.skeleton.core.skeleton.domain.TestObj1;
import personal.yerim.skeleton.core.skeleton.domain.TestObj1Repository;

@Service
@RequiredArgsConstructor
public class TestObj1Service {

  private final TestObj1Repository repository;

  public long create(TestObj1CreateDto createDto) {
    TestObj1 testObj1 = repository.save(TestObj1.builder()
        .id(repository.generateId())
        .value(createDto.getValue())
        .createdAt(createDto.getCreatedAt())
        .build());

    return testObj1.getId();
  }

  public CursorPageResult<TestObj1> getPageInCreatedOrder(CursorCreatedAtPageRequest pageRequest) {
    List<TestObj1> testObj1s = repository.getListOrderByCreatedDesc(
        pageRequest.lastCreatedAt(),
        pageRequest.lastId(),
        pageRequest.pageSize()
    );
    if (testObj1s.isEmpty()) {
      return new CursorPageResult<>(testObj1s, null, null, pageRequest.pageSize());
    }
    TestObj1 lastObj = testObj1s.get(testObj1s.size() - 1);
    return new CursorPageResult<>(testObj1s,
        lastObj.getCreatedAt(), lastObj.getId(), pageRequest.pageSize());
  }
}
