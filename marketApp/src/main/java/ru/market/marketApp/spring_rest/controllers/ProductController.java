package ru.market.marketApp.spring_rest.controllers;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.market.marketApp.spring_rest.dto.ProductDto;
import ru.market.marketApp.spring_rest.exceptions.ResourceNotFoundException;
import ru.market.marketApp.spring_rest.model.Product;
import ru.market.marketApp.spring_rest.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;


    @GetMapping("/products")
    public List<ProductDto> findByAll() {
        return productService.findByAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }


    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found, id: " + id));
    }

    @GetMapping("/products/delete/{id}")
    public void deleteFindById(@PathVariable Long id){
        productService.deleteFindById(id);
    }

    @PostMapping("/products/save")
    public Product findById(Product product){
       return productService.updateOfSave(product);
    }


    @GetMapping("/products/findCost")
    public List<Product> findProductsByCostBetween(@RequestParam (name = "min") int minCost,
                                                   @RequestParam (name = "min") int maxCost){

        return productService.findProductsByCostBetween(minCost, maxCost);
    }
}
