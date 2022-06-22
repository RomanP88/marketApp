package ru.market.marketApp.spring_rest.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.market.marketApp.spring_rest.model.Category;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByTitle(String title);
}
