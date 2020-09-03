package cn.yuehai.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class YhGateway {
    public static void main(String[] args) {
        SpringApplication.run(YhGateway.class);
    }
}
