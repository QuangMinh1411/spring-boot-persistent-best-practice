package com.quangminh.timezone.repository;

import com.quangminh.timezone.entity.ScreenShot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ScreenShotRepository extends JpaRepository<ScreenShot, Long> {
    @Transactional(readOnly=true)
    ScreenShot findByName(String name);
}