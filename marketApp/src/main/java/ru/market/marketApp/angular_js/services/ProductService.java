package ru.market.marketApp.angular_js.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.market.marketApp.angular_js.model.Product;
import ru.market.marketApp.angular_js.repositories.ProductRepository;

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


    public List<Product> findProductsByCostBetween(int minCost, int maxCost){
        return productRepository.findProductsByCostBetween(minCost, maxCost);
    }

}



