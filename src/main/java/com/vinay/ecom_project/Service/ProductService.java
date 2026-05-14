package com.vinay.ecom_project.Service;

import com.vinay.ecom_project.Model.Product;
import com.vinay.ecom_project.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepo repo;

    //This fun is for to return all the products
    public List<Product> getAllProducts() {
        return repo.findAll();
    }
    //This fun is for to return the specific product using id
    public Product getProductByid(int id) {
        return repo.findById(id).orElse(new Product());
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
       product.setImageName(imageFile.getOriginalFilename());
       product.setImageType(imageFile.getContentType());
       product.setImageData(imageFile.getBytes());
       return repo.save(product);
    }

//    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
//        product.setImageData(imageFile.getBytes());
//        product.setImageName(imageFile.getOriginalFilename());
//        product.setImageType(imageFile.getContentType());
//       return repo.save(product);
//    }
public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {

    Product existingProduct = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));

    existingProduct.setName(product.getName());
    existingProduct.setDescription(product.getDescription());
    existingProduct.setBrand(product.getBrand());
    existingProduct.setPrice(product.getPrice());
    existingProduct.setCategory(product.getCategory());
    existingProduct.setReleaseDate(product.getReleaseDate());
    existingProduct.setStockQuantity(product.getStockQuantity());
    existingProduct.setProductAvailable(product.isProductAvailable());

    if (imageFile != null && !imageFile.isEmpty()) {
        existingProduct.setImageData(imageFile.getBytes());
        existingProduct.setImageName(imageFile.getOriginalFilename());
        existingProduct.setImageType(imageFile.getContentType());
    }

    return repo.save(existingProduct);
}

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}

