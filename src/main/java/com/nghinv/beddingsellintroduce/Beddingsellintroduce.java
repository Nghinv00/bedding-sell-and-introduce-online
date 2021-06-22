package com.nghinv.beddingsellintroduce;

import com.nghinv.beddingsellintroduce.common.Dto.Demo;
import com.nghinv.beddingsellintroduce.common.Validator.MemberRestValidator;
import com.nghinv.beddingsellintroduce.common.Validator.MembersValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
@RestController
public class Beddingsellintroduce {

	public static void main(String[] args) {
		SpringApplication.run(Beddingsellintroduce.class, args);
	}

	@Bean
	public Validator memberValidator()
	{
		Validator bean = new MembersValidator();
		return bean;
	}

	@Bean
	public Validator memberRestValidator()
	{
		Validator bean = new MemberRestValidator();
		return bean;
	}

	@RequestMapping(value="/getdata", method= RequestMethod.GET)
	public ResponseEntity<Object> getData() {
		Demo demo = new Demo();
		demo.setId("1");
		demo.setName("talk2Amareswaran");
		return new ResponseEntity<>(demo, HttpStatus.OK);
	}

	@RequestMapping(value="/postdata", method=RequestMethod.POST)
	public ResponseEntity<Object> postData(@RequestBody Demo demo) {
		System.out.println("demo id:"+demo.getId());
		System.out.println("demo name:"+demo.getName());
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

	// GET
	// SET

	@PostConstruct
	public void postConstruct(){
		System.out.println("\tSpring Bean Life Cycle – @PostConstruct >> Init");
	}

	@PreDestroy
	public void preDestroy(){
		System.out.println("\tSpring Bean Life Cycle – @PreDestroy>> Destroy");
	}


//		// ApplicationContext chính là container, chứa toàn bộ các Bean
//		ApplicationContext context = SpringApplication.run(MinamisomaankenApplication.class, args);
//
//		// Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
//		// dấu @Component.
//
//		// Lấy Bean ra bằng cách
//		Outfit outfit = context.getBean(Outfit.class);
//
//		// In ra để xem thử nó là gì
//		System.out.println("Instance: " + outfit);
//		// xài hàm wear()
//		outfit.wear();

//
//		// ApplicationContext chính là container, chứa toàn bộ các Bean
//		ApplicationContext context = SpringApplication.run(MinamisomaankenApplication.class, args);
//		// Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
//		// dấu @Component.
//
//		// Lấy Bean ra bằng cách
//		Outfit outfit = context.getBean(Outfit.class);
//
//		// In ra để xem thử nó là gì
//		System.out.println("Output Instance: " + outfit);
//		// xài hàm wear()
//		outfit.wear();
//		Girl girl = context.getBean(Girl.class);
//		System.out.println("Girl Instance: " + girl);
//		System.out.println("Girl Outfit: " + girl.outfit);
//		girl.outfit.wear();
//		// ApplicationContext chính là container, chứa toàn bộ các Bean
//		System.out.println("> Trước khi IoC Container được khởi tạo");
//		ApplicationContext context = SpringApplication.run(MinamisomaankenApplication.class, args);
//		System.out.println("> Sau khi IoC Container được khởi tạo");
//
//		// Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
//		// dấu @Component.
//
//		Girl girl = context.getBean(Girl.class);
//
//		System.out.println("> Trước khi IoC Container destroy Girl");
//		((ConfigurableApplicationContext) context).getBeanFactory().destroyBean(girl);
//		System.out.println("> Sau khi IoC Container destroy Girl");
}
