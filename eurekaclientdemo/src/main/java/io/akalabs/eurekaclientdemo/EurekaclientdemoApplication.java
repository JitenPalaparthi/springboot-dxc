package io.akalabs.eurekaclientdemo;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@SpringBootApplication
@EnableDiscoveryClient
public class EurekaclientdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaclientdemoApplication.class, args);
	}

}

@RestController
class ServiceClientController{
@Autowired
DiscoveryClient discoveryClient;

@GetMapping("/service-instances/{appname}")
public List<ServiceInstance> getServiceInstances(@PathVariable("appname") String appname){
	return discoveryClient.getInstances(appname);

}

}