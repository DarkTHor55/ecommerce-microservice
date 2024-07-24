package com.darkthor.product_server.Service;

import com.darkthor.product_server.Exception.ProductNotFound;
import com.darkthor.product_server.Model.Product;
import com.darkthor.product_server.Repository.ProductRepository;
import com.darkthor.product_server.Request.ProductPurchaseRequest;
import com.darkthor.product_server.Request.ProductRequest;
import com.darkthor.product_server.Response.ProductPurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductMapper mapper;
    public Product createProduct(ProductRequest request) {
        Product product = mapper.toProduct(request);
        return repository.save(product);
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }


    public Product deleteProduct(int id) {
        Product product = repository.findById(id).orElse(null);
        if (product!=null){
            repository.delete(product);
            return product;
        } else {
            return null;
        }
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> request) throws ProductNotFound {
//        extract all products Id
       var responses = request.stream().map(ProductPurchaseRequest::getProductId).toList();
//       Check all product which we have to purchase thy already exists or not in database
       var storeProduct=repository.findAllByIdInOrderById(responses);
//       check we have all products which are requested if not so throw exception
       if (responses.size()!=storeProduct.size()) {
           throw new ProductNotFound("One or more products are not exists");
       }
// extracted ids of all stored request
       var storeRequest=request.stream().sorted(Comparator.comparing(ProductPurchaseRequest::getProductId)).toList();
//       create a object pf purchase product
       var purchasedProduct=new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storeProduct.size(); i++) {
            var product = storeProduct.get(i);
            var requestProduct = storeRequest.get(i);
//            check the quantity is sufficient for the purchase if not then throw exception
            if(product.getAvailableQuantity()< requestProduct.getQuantity()){
                throw new ProductNotFound("Insufficient quantity for product with product Id :"+product.getId());
            }
//            update available quantity
            var newAvailableQuantity = product.getAvailableQuantity()- requestProduct.getQuantity();
//            update product and save it into database
            product.setAvailableQuantity(newAvailableQuantity);
            repository.save(product);
//            return  the list of purchases product
            purchasedProduct.add(mapper.toProductPurchasedResponse(product,requestProduct.getQuantity()));
        }
        return purchasedProduct;

    }
    //    public Product updateProduct(Long id, ProductRequest request) {
//    }

}
