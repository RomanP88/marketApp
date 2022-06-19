package ru.market.marketApp.angular_js.controllers;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.market.marketApp.angular_js.exceptions.ResourceNotFoundException;
import ru.market.marketApp.angular_js.model.Product;
import ru.market.marketApp.angular_js.services.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;


    @GetMapping("/products")
    public List<Product> findByAll() {
        return   productService.findByAll();
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
