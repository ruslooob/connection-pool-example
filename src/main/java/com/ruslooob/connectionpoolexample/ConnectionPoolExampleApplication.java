package com.ruslooob.connectionpoolexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionPoolExampleApplication {
    // провести тестирование и посмотреть какая загрузка cpu и memory
    // найти максимум
    // найти узкое место в приложении (это будет бд)
    // увеличить connection pool
    public static void main(String[] args) {
        SpringApplication.run(ConnectionPoolExampleApplication.class, args);
    }

}
