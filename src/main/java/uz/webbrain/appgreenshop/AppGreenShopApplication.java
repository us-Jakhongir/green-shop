package uz.webbrain.appgreenshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppGreenShopApplication {

    @GetMapping("/api/test")
    public ResponseEntity<?> showResult() {
        return ResponseEntity.ok("Hello Heroku from Spring Boot");
    }

    public static void main(String[] args) {
        SpringApplication.run(AppGreenShopApplication.class, args);
    }

}
