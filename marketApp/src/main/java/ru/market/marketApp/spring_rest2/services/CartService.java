package ru.market.marketApp.spring_rest2.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.market.marketApp.spring_rest1.exceptions.ResourceNotFoundException;
import ru.market.marketApp.spring_rest2.cart.Cart;
import ru.market.marketApp.spring_rest2.model.Product;
import ru.market.marketApp.spring_rest2.repositories.ProductRepository;

import java.util.List;

@Service
@Component
@Data
@RequiredArgsConstructor
public class CartService {

    private final ProductRepository productRepository;
    private final Cart cart;



    public List<Product> cartAllOfProduct(){
        return cart.getCartAllProduct();
    }

    public void addCart(Long id){
        cart.getCartAllProduct().add(productRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Product not found, id: " + id)));
    }

    public void deleteCart(Long id){
        cart.getCartAllProduct().removeIf(product -> product.getId().equals(id));
    }

}
