package br.edu.iftm.tspi.product_api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.iftm.tspi.product_api.model.Product;
import br.edu.iftm.tspi.product_api.model.dto.ProductDTO;
import br.edu.iftm.tspi.product_api.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Busca todos os produtos
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<ProductDTO> productDtos = products.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productDtos);
    }

    // Busca um produto pelo ID
    public ResponseEntity<ProductDTO> findById(ObjectId id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Product> product = productRepository.findById(id);
        return product.map(p -> ResponseEntity.ok(new ProductDTO(p)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Salva um novo produto
    public ResponseEntity<ProductDTO> save(Product product) {
        if (product.getCategoriaId() == null) {
            return ResponseEntity.badRequest().build();
        }

        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
    }

    // Atualiza um produto existente
    public ResponseEntity<ProductDTO> update(ObjectId id, ProductDTO productDto) {
        if (id == null || productDto == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Product product = existingProduct.get();
        product.setNome(productDto.getNome());
        product.setDescricao(productDto.getDescricao());
        product.setPreco(productDto.getPreco());
        if (productDto.getCategoriaId() != null) {
            product.setCategoriaId(new ObjectId(productDto.getCategoriaId()));
        }

        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(new ProductDTO(updatedProduct));
    }

    // Deleta um produto
    public ResponseEntity<Void> delete(ObjectId id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        if (!productRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Busca todos os produtos de forma paginada
    public ResponseEntity<Page<ProductDTO>> findAllPageable(Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);
        Page<ProductDTO> dtoPage = productPage.map(ProductDTO::new);
        return ResponseEntity.ok(dtoPage);
    }

    // Busca produtos por categoria
    public ResponseEntity<List<ProductDTO>> findByCategoryId(ObjectId categoryId) {
        if (categoryId == null) {
            return ResponseEntity.badRequest().build();
        }

        List<Product> products = productRepository.findByCategoriaId(categoryId);
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<ProductDTO> productDtos = products.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productDtos);
    }

    // Busca produto pelo identificador único
    public ResponseEntity<ProductDTO> findByProductIdentifier(String productIdentifier) {
        if (productIdentifier == null || productIdentifier.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Product> product = productRepository.findByProductIdentifier(productIdentifier);
        return product.map(p -> ResponseEntity.ok(new ProductDTO(p)))
                .orElse(ResponseEntity.notFound().build());
    }
}
