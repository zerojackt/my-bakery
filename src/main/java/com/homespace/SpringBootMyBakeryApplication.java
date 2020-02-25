package com.homespace;

import java.util.stream.IntStream;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.homespace.domain.Question;
import com.homespace.domain.User;
import com.homespace.repository.QuestionRepository;
import com.homespace.repository.UserRepository;




@SpringBootApplication
public class SpringBootMyBakeryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBakeryApplication.class, args);
	}
	
	 @Bean
	    public CommandLineRunner initData(UserRepository userRepository, QuestionRepository questionRepository) {
	        return args ->
	                IntStream.rangeClosed(1, 154).forEach(i -> {
	                    User user =  User.builder()
	                            .passoword("1234"+i)
	                    		.username("tester" + i)
	                            .build();

	                    userRepository.save(user);

	                    Question question = Question.builder()
	                            .title("test" + i)
	                            .writer(user)
	                            .contents("content"+i)
	                            .viewCount(i)
	                            .build();

	                    questionRepository.save(question);
	                });
	    }

}
