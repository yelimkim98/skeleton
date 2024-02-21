package personal.yerim.skeleton.api.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import personal.yerim.skeleton.core.application.service.TestObj1Service;
import personal.yerim.skeleton.core.application.service.dto.TestObj1CreateDto;

@Service
@RequiredArgsConstructor
public class TestCommandService {

  private final TestObj1Service testObj1Service;

  public long createTestObj1(TestObj1CreateDto createDto) {
    return testObj1Service.create(createDto);
  }
}
