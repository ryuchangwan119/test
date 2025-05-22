package test.spring.mvc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// SpirngjpaEx01Application: 애플리케이션의 메인 클래스
// implements CommandLineRunner: Spring Boot가 애플리케이션 실행 후 run() 메서드를 자동으로 호출하도록 해주는 인터페이스
@SpringBootApplication
public class OrmjpaApplication{	// 애플리케이션의 메인 클래스

	public static void main(String[] args) {
		SpringApplication.run(OrmjpaApplication.class, args);
	}
}
