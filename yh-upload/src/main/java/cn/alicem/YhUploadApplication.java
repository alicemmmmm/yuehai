package cn.alicem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName YhUploadApplication
 * @Description TODO
 * @Author LiHongBin
 * @Date 2020\7\15 0015 16:15
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class YhUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(YhUploadApplication.class);
    }
}
