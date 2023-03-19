package softgen.shoptask;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@OpenAPIDefinition(
        info=@Info(
                title = "Spring Boot Tutorial",
                version = "v1",
                description = "Spring Boot Tutorial API"
        )
)
@SpringBootApplication
public class ShopTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopTaskApplication.class, args);
        //System.out.println(new BCryptPasswordEncoder().encode("levan"));
    }
}