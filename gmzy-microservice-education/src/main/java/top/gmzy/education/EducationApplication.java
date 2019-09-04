package top.gmzy.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wgm
 */
@SpringBootApplication
@ComponentScan(basePackages={"top.gmzy.education","top.gmzy.common"})
@EnableEurekaClient
public class EducationApplication {

	public static void main(String[] args){
		SpringApplication.run(EducationApplication.class, args);
	}
}
