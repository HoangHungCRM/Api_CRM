package com.resdii.crm.user;

import com.resdii.ms.common.rest.NooApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Application extends NooApplication {
	public static void main(String[] args) {
		runApplication(Application.class, args);
	}
}
