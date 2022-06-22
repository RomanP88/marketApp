package ru.market.marketApp.spring_rest.controllers;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.market.marketApp.spring_rest.dto.ProductDto;
import ru.market.marketApp.spring_rest.exceptions.ResourceNotFoundException;
import ru.market.marketApp.spring_rest.model.Category;
import ru.market.marketApp.spring_rest.model.Product;
import ru.market.marketApp.spring_rest.services.CategoryService;
import ru.market.marketApp.spring_rest.services.ProductService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;

    private  final CategoryService categoryService;

    @GetMapping("/products")
    public List<ProductDto> findByAll() {
        return productService.findByAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }


    @GetMapping("/products/{id}")
    public ProductDto findById(@PathVariable Long id){
        return new ProductDto(productService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found, id: " + id)));
    }

    @GetMapping("/products/delete/{id}")
    public void deleteFindById(@PathVariable Long id){
        productService.deleteFindById(id);
    }

    @PostMapping("/products")
    public ProductDto save(@RequestBody ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setCost(productDto.getCost());
        Category category = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(()->
                new ResourceNotFoundException("Category not found, title: " + productDto.getCategoryTitle()));
        product.setCategory(category);
        productService.updateOfSave(product);
        return new ProductDto(product);
    }


    @GetMapping("/products/findCost")
    public List<Product> findProductsByCostBetween(@RequestParam (name = "min") int minCost,
                                                   @RequestParam (name = "min") int maxCost){

        return productService.findProductsByCostBetween(minCost, maxCost);
    }
}
