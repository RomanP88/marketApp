package ru.market.marketApp.spring_rest1.services;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.market.marketApp.spring_rest1.dto.ProductDto;
import ru.market.marketApp.spring_rest1.exceptions.ResourceNotFoundException;
import ru.market.marketApp.spring_rest1.model.Category;
import ru.market.marketApp.spring_rest1.model.Product;
import ru.market.marketApp.spring_rest1.repositories.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;


  public Page<Product> findByAll(int pageIndex, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageIndex, pageSize));
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

    @Transactional
    public void updateProduct(ProductDto productDto) {
        Product product = findById(productDto.getId()).orElseThrow(()
                -> new ResourceNotFoundException("Category not found, id: " + productDto.getId()));;
        product.setTitle(productDto.getTitle());
        product.setCost(productDto.getCost());
        Category category = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(()
                -> new ResourceNotFoundException("Category not found, title: " + productDto.getCategoryTitle()));
        product.setCategory(category);

    }


}



