package ru.market.marketApp.spring_rest2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.market.marketApp.spring_rest2.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
