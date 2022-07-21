package ru.market.marketApp.spring_rest2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ru.market.marketApp.spring_rest1.exceptions.ResourceNotFoundException;
import ru.market.marketApp.spring_rest2.dto.ProductDto;
import ru.market.marketApp.spring_rest2.model.Category;
import ru.market.marketApp.spring_rest2.model.Product;
import ru.market.marketApp.spring_rest2.services.CartService;
import ru.market.marketApp.spring_rest2.services.CategoryService;
import ru.market.marketApp.spring_rest2.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Component
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;


    @GetMapping("/carts")
    public List<ProductDto> findByAll() {
        return cartService.cartAllOfProduct().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @GetMapping("/carts/delete/{id}")
    public void deleteFindById(@PathVariable Long id) {
        cartService.deleteCart(id);
    }


    @PostMapping("/carts/{id}")
    public void addFindById(@PathVariable Long id) {
        cartService.addCart(id);

    }
}





