package personal.yerim.skeleton.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "personal.yerim.skeleton")
public class SkeletonBatchApplication {

  public static void main(String[] args) {
    SpringApplication.run(SkeletonBatchApplication.class, args);
  }
}
