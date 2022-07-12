package ru.market.marketApp.spring_rest2;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import ru.market.marketApp.spring_rest2.cart.Cart;
import ru.market.marketApp.spring_rest2.model.Product;
import ru.market.marketApp.spring_rest2.repositories.ProductRepository;

import java.util.List;

@SpringBootApplication
public class MarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}


}
