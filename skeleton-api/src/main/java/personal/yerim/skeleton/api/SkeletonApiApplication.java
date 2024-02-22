package personal.yerim.skeleton.api;

import jakarta.annotation.PostConstruct;
import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "personal.yerim.skeleton")
public class SkeletonApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(SkeletonApiApplication.class, args);
  }

  @PostConstruct
  public void initTimeZone() {
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
  }
}
