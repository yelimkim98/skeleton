package personal.yerim.skeleton.api.skeleton.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import personal.yerim.skeleton.core.skeleton.application.TestObj1Service;
import personal.yerim.skeleton.core.skeleton.application.dto.TestObj1CreateDto;

@Service
@RequiredArgsConstructor
public class TestCommandService {

  private final TestObj1Service testObj1Service;

  public long createTestObj1(TestObj1CreateDto createDto) {
    return testObj1Service.create(createDto);
  }
}
