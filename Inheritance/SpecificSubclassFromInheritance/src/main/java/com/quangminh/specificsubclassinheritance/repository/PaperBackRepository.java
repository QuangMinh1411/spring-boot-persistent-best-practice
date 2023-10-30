package com.quangminh.specificsubclassinheritance.repository;

import com.quangminh.specificsubclassinheritance.entity.PaperBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperBackRepository extends JpaRepository<PaperBack, Long> {
}