package com.axoulotl.jvtheque.repository;

import com.axoulotl.jvtheque.model.entity.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Integer> {
}
