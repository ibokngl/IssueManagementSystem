package com.ibcaka.issuemanagement;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IssueManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssueManagementApplication.class, args);
	}

	//ModelMapper kullanmak için uygulamada(IssueManagementApplication.java) instanceını yaratmamız gereklidir.
	@Bean // uygulama contextini dahil etmek için kullanılır yani aşağıdaki nesnede bir tane oluştur springin IOC Containerına koy sonra herkes erişebilsin
	public ModelMapper getModelMapper()	{
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}
