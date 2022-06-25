package ru.market.marketApp.spring_rest.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.market.marketApp.spring_rest.model.Product;
import ru.market.marketApp.spring_rest.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> findByAll() {
        return productRepository.findAll();
    }


    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteFindById(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateOfSave(Product product) {
       return productRepository.save(product);
    }




}



