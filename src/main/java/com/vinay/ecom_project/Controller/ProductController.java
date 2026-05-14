package com.vinay.ecom_project.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vinay.ecom_project.Model.Product;
import com.vinay.ecom_project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getallProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductByid(@PathVariable int id) {
        Product product = service.getProductByid(id);
        if (product != null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @PostMapping(value = "/product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<?> addProduct(
        @RequestPart("product") String productJson,
        @RequestPart("imageFile") MultipartFile imageFile
) throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    Product product = mapper.readValue(productJson, Product.class);

    Product product1 = service.addProduct(product, imageFile);

    return new ResponseEntity<>(product1, HttpStatus.CREATED);
}

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId) {
        Product product = service.getProductByid(productId);
        byte[] imageFile = product.getImageData();
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }


@PutMapping(value = "/product/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<?> updateProduct(
        @PathVariable int id,
        @RequestPart("product") String productJson,
        @RequestPart(value = "imageFile", required = false) MultipartFile imageFile
) {
    try {

        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.readValue(productJson, Product.class);

        Product updatedProduct = service.updateProduct(id, product, imageFile);

        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);

    } catch (Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product=service.getProductByid(id);
        if(product != null){
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }else
            return new ResponseEntity<>("Product Not Found",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
        List<Product> products= service.searchProducts(keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
