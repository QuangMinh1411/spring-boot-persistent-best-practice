package com.quangminh.timezone.service;

import com.quangminh.timezone.entity.ScreenShot;
import com.quangminh.timezone.repository.ScreenShotRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

@Service
public class ScreenShotService {

    private final ScreenShotRepository screenShotRepository;

    public ScreenShotService(ScreenShotRepository screenShotRepository) {
        this.screenShotRepository = screenShotRepository;
    }
    public void saveScreenshotInUTC() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));

        ScreenShot screenshot = new ScreenShot();

        screenshot.setName("Screenshot-1");
        screenshot.setCreateOn(new Timestamp(
                ZonedDateTime.of(2018, 3, 30, 10, 15, 55, 0,
                        ZoneId.of("UTC")
                ).toInstant().toEpochMilli()
        ));

        System.out.println("Timestamp epoch milliseconds before insert: "
                + screenshot.getCreateOn().getTime());

        screenShotRepository.save(screenshot);
    }

    public void displayScreenshotInUTC() {
        ScreenShot fetchScreenshot = screenShotRepository.findByName("Screenshot-1");
        System.out.println("Timestamp epoch milliseconds after fetching: "
                + fetchScreenshot.getCreateOn().getTime());
    }
}
