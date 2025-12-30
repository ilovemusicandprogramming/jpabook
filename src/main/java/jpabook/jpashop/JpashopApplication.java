package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpashopApplication.class, args);
	}

	@Bean
	Hibernate5JakartaModule hibernate5Module() { // 클래스명 수정
		Hibernate5JakartaModule hibernate5Module = new Hibernate5JakartaModule();

		// 강제 지연 로딩 설정
		// 이 설정을 켜면 이제 Jackson이 지연 로딩된 객체 내부로 끝까지 파고듬(사용하면 안되는 option)
		// hibernate5Module.configure(Hibernate5JakartaModule.Feature.FORCE_LAZY_LOADING, true);

		return hibernate5Module;
	}
}
