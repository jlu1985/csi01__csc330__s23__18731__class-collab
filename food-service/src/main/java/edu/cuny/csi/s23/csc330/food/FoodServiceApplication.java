package edu.cuny.csi.s23.csc330.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;

import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
@EnableWebSocket
public class FoodServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodServiceApplication.class, args);
    }

    @Bean
    public WebSocketConfigurer websockets(Drivers drivers, Stores stores) {

        return registry ->
                registry.addHandler(drivers, "/driver")
                        .addHandler(stores, "/store");

    }

    @Bean
    public ConcurrentHashMap<String, String> memoryOrderMap() {
        return new ConcurrentHashMap<>();
    }


}
