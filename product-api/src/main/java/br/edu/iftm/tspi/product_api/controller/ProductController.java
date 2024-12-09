package br.edu.iftm.tspi.product_api.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.tspi.product_api.model.Category;
import br.edu.iftm.tspi.product_api.model.Product;
import br.edu.iftm.tspi.product_api.model.dto.ProductDTO;
import br.edu.iftm.tspi.product_api.service.CategoryService;
import br.edu.iftm.tspi.product_api.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    private CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable ObjectId id) {
        return productService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable ObjectId id, @RequestBody ProductDTO productDto) {
        return productService.update(id, productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ObjectId id) {
        return productService.delete(id);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<ProductDTO>> getAllPage(Pageable pageable) {
        return productService.findAllPageable(pageable);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getProductByCategoryId(@PathVariable ObjectId categoryId) {
        return productService.findByCategoryId(categoryId);
    }

    @GetMapping("/identifier/{productIdentifier}")
    public ResponseEntity<ProductDTO> findByProductIdentifier(@PathVariable String productIdentifier) {
        return productService.findByProductIdentifier(productIdentifier);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable ObjectId id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable ObjectId id) {
        return categoryService.delete(id);
    }
}
