package com.darkthor.product_server.Service;

import com.darkthor.product_server.Model.Category;
import com.darkthor.product_server.Model.Product;
import com.darkthor.product_server.Request.ProductRequest;
import com.darkthor.product_server.Response.ProductPurchaseResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        if (request==null){
            return null;
        }
        return Product.builder()
                .id(request.getId())
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .availableQuantity(request.getAvailableQuantity())
                .category(Category
                        .builder()
                        .id(request.getCategoryId())
                        .build()
                ).build();
    }


    public ProductPurchaseResponse toProductPurchasedResponse(Product product, double quantity) {
        if (product==null){
            return null;
        }
        return ProductPurchaseResponse.builder()
               .id(product.getId())
               .name(product.getName())
               .description(product.getDescription())
               .price(product.getPrice())
               .quantity(quantity)
               .build();
    }
}
