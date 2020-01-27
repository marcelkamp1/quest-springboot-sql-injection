package com.bankzecure.webapp;

import org.owasp.esapi.codecs.MySQLCodec;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.bankzecure.webapp.repository.CustomerRepository;

@Controller
@SpringBootApplication
public class WebappApplication {
  private CustomerRepository repository = new CustomerRepository();

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
		
		MySQLCodec codec = new MySQLCodec(MySQLCodec.Mode.STANDARD);
		String rawValue = "' OR 1=1 -- ;";
		char[] immune = {};
		
		String escapedValue = codec.encode(immune, rawValue);
		System.out.println(escapedValue);
  }

  @GetMapping("/")
  String home() {
    return "signin_form";
  }

}
