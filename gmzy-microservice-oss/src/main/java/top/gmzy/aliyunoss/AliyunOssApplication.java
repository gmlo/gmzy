package top.gmzy.aliyunoss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wgm
 * @since 2019/6/28
 */
@SpringBootApplication
public class AliyunOssApplication {

	public static void main(String[] args){
		SpringApplication.run(AliyunOssApplication.class, args);
//		com.bao
	}
}
