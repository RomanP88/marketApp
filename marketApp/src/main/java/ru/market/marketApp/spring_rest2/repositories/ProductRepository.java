package ru.market.marketApp.spring_rest2.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.market.marketApp.spring_rest2.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
