package ru.market.marketApp.spring_rest2.cart;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.market.marketApp.spring_rest2.model.Product;

import java.util.ArrayList;
import java.util.List;
@Component
@Data
@RequiredArgsConstructor
public class Cart {





   private List<Product> cartAllProduct = new ArrayList<>();



}
