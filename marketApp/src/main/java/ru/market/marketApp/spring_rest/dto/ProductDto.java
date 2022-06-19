package ru.market.marketApp.spring_rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.market.marketApp.spring_rest.model.Product;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String title;
    private int cost;
    private String categoryTitle;


    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.cost = product.getCost();
        this.categoryTitle = product.getCategory().getTitle();
    }
}
