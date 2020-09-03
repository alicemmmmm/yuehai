package cn.yuehai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication/*(scanBasePackages = {cn.yuehai.})*/
@EnableDiscoveryClient
@MapperScan("cn.yuehai.item.mapper")
public class YhItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(YhItemApplication.class);
    }
}
