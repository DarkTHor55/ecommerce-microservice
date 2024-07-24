package com.darkthor.product_server.Controller;

import com.darkthor.product_server.Exception.ProductNotFound;
import com.darkthor.product_server.Model.Product;
import com.darkthor.product_server.Request.ProductPurchaseRequest;
import com.darkthor.product_server.Request.ProductRequest;
import com.darkthor.product_server.Response.ProductPurchaseResponse;
import com.darkthor.product_server.Service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private final ProductService productService;
    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>>productPurchase(@RequestBody List<ProductPurchaseRequest>request) throws ProductNotFound {
        return ResponseEntity.ok(productService.purchaseProduct(request));
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest request) {
        Product product = productService.createProduct(request);
        if (product==null){
            return ResponseEntity.badRequest().body("Invalid product data");
        }
        else{
            return ResponseEntity.ok("Product created successfully");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@RequestParam int id){
        Product product = productService.getProductById(id);
        if (product==null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(product);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product = productService.deleteProduct(id);
        if (product==null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok("Product deleted successfully");
        }
    }
    @GetMapping("/all")
    public ResponseEntity<Iterable<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
//    // create in future versions
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request){
//        Product product = productService.updateProduct(id, request);
//        if (product==null){
//            return ResponseEntity.notFound().build();
//        }
//        else{
//            return ResponseEntity.ok("Product updated successfully");
//        }
//    }

}
