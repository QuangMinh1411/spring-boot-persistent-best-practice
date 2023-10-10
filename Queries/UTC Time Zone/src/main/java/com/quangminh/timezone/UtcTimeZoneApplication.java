package com.quangminh.timezone;

import com.quangminh.timezone.service.ScreenShotService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UtcTimeZoneApplication {


    private final ScreenShotService screenShotService;

    public UtcTimeZoneApplication(ScreenShotService screenShotService) {
        this.screenShotService = screenShotService;
    }

    public static void main(String[] args) {
        SpringApplication.run(UtcTimeZoneApplication.class, args);
    }

    @Bean
    public ApplicationRunner init(){
        return args -> {
            screenShotService.saveScreenshotInUTC();
            screenShotService.displayScreenshotInUTC();
        };
    }
}
