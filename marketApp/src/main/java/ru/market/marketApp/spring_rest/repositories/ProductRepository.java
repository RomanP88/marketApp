package ru.market.marketApp.spring_rest.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.market.marketApp.spring_rest.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
