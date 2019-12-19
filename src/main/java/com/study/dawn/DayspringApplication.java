package com.study.dawn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.study.dawn.dao")
public class DayspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DayspringApplication.class, args);
	}

   /*
    * SqlSessionFactory 설정
    */
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);
//
//
//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//
//		sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
//
//
//		return sessionFactory.getObject();
//	}

}
