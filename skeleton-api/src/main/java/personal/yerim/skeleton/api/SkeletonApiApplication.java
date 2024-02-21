package personal.yerim.skeleton.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "personal.yerim.skeleton")
public class SkeletonApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(SkeletonApiApplication.class, args);
  }
}
