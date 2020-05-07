package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/5/6 22:19
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaProviderPayment9003Main {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaProviderPayment9003Main.class, args);
    }
}
