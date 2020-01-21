package com.project.example.model.imdb.UserNew;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User, Integer> {
}
