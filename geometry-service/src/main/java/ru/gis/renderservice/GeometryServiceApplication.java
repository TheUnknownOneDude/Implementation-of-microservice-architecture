package ru.gis.renderservice;

import org.locationtech.jts.io.WKTReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import ru.gis.renderservice.domain.GeometryObject;
import ru.gis.renderservice.service.GeometryObjectService;

@SpringBootApplication
@EnableDiscoveryClient
public class GeometryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeometryServiceApplication.class, args);
    }


//    @Bean
//    public CommandLineRunner DBFill(GeometryObjectService service) {
//        return args -> {
//            for (int i = 0; i < 1; i++) {
//                service.save("POINT(" + i + " " + i + ")", "#000000");
//            }
//        };
//    }
}
