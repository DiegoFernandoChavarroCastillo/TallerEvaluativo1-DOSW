package com.taller1;



import com.taller1.model.Product;
import com.taller1.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TallerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TallerApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ProductService productService) {
        return args -> {
            productService.addProduct(new Product("Laptop", 2500.0, 10, "Electrónica"));
            productService.addProduct(new Product("Mouse", 30.0, 3, "Accesorios"));

            System.out.println(">>> Productos iniciales cargados.");

            productService.updateStock("Mouse", 2);   // debería activar WarningAgent
            productService.updateStock("Laptop", 9);  // debería activar LogAgent
        };
    }
}

