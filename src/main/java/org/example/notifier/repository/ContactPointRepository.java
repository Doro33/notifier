package org.example.notifier.repository;

import org.example.notifier.entity.ContactPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactPointRepository extends JpaRepository<ContactPoint,Long> {
}
