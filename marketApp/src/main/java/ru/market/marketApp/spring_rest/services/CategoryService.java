package ru.market.marketApp.spring_rest.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.market.marketApp.spring_rest.model.Category;
import ru.market.marketApp.spring_rest.repositories.CategoryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }
}