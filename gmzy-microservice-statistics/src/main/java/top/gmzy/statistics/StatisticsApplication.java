package top.gmzy.statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"top.gmzy.statistics","top.gmzy.common"})
@EnableEurekaClient
public class StatisticsApplication {
	public static void main(String[] args) {
		SpringApplication.run(StatisticsApplication.class, args);
	}
}