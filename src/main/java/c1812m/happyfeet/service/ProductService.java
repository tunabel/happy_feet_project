package c1812m.happyfeet.service;

import c1812m.happyfeet.commons.exception.CustomNotFoundException;
import c1812m.happyfeet.commons.mapper.ProductMapper;
import c1812m.happyfeet.dto.ProductDto;
import c1812m.happyfeet.model.Product;
import c1812m.happyfeet.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public Product findById(int id) {
        Optional<Product> productOptional = productRepository.findByIdAndStatus(id, 1);

        return productOptional.orElse(null);
    }

    public Product save(ProductDto dto) {
        Product product = productMapper.toEntity(dto);

        Product foundProduct = productRepository.findFirstByName(dto.getName());

        if (foundProduct != null) {
            return null;
        } else {
            return productRepository.save(product);
        }
    }

    public List<Product> findAll() {
        return productRepository.findAllByStatus(1);
    }

    public Product update(ProductDto dto, int productId) {

        if (dto.getId() != productId) {
            return null;
        }

        Product product = findById(dto.getId());

        Product foundProduct = productRepository.findFirstByName(dto.getName());

        if (product != null) {
            if (foundProduct != null && foundProduct.getId() != product.getId()) {
                return null;
            }

            return productRepository.save(product);
        } else {
            return null;
        }
    }

    public List<Product> findAllActive() {

        return productRepository.findAllByStatus(1);
    }

    public Product findActiveById(int productId) {

        Optional<Product> productOptional = productRepository.findByIdAndStatus(productId, 1);

        if (productOptional.isPresent()) {
            return productOptional.get();
        } else {
            throw new CustomNotFoundException("Product Id doesn't exist");
        }
    }
}
