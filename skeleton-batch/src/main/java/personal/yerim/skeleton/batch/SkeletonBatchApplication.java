package personal.yerim.skeleton.batch;

import jakarta.annotation.PostConstruct;
import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "personal.yerim.skeleton")
public class SkeletonBatchApplication {

  public static void main(String[] args) {
    System.setProperty("spring.devtools.restart.enabled", "false");
    System.setProperty("user.timezone", "Asia/Seoul");

    ConfigurableApplicationContext applicationContext =
        SpringApplication.run(SkeletonBatchApplication.class, args);
    System.exit(SpringApplication.exit(applicationContext));
  }

  @PostConstruct
  public void initTimeZone() {
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
  }
}
