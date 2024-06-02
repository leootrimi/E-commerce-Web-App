package com.eCommerce.eCommerceApp.Service;

import com.eCommerce.eCommerceApp.Models.Cart;
import com.eCommerce.eCommerceApp.Models.Product;
import com.eCommerce.eCommerceApp.Repository.CartRepository;
import com.eCommerce.eCommerceApp.Repository.ProductRepository;
import com.eCommerce.eCommerceApp.Services.ServiceImpl.CartServiceImpl;
import com.eCommerce.eCommerceApp.Services.ServiceImpl.ProductServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImp productService;
    @Mock
    private CartRepository cartRepository;

    @Test
    public void saveProductTest() {
        Product product = new Product();
        product.setTitle("Test Product");
        product.setPrice(10.0);
        product.setDescription("Test description");
        product.setImage("test-image.jpg");

        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product savedProduct = productService.saveProduct(product);

        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getTitle()).isEqualTo("Test Product");
        assertThat(savedProduct.getPrice()).isEqualTo(10.0);
        assertThat(savedProduct.getDescription()).isEqualTo("Test description");
        assertThat(savedProduct.getImage()).isEqualTo("test-image.jpg");
    }
    @Test
    public void getAllProductsTest() {
        List<Product> productList = new ArrayList<>();

        Product product = new Product();
        product.setTitle("Test Product");
        product.setPrice(10.0);
        product.setDescription("Test description");
        product.setImage("test-image.jpg");

        Product product1 = new Product();
        product.setTitle("Test Product");
        product.setPrice(10.0);
        product.setDescription("Test description");
        product.setImage("test-image.jpg");

        productList.add(product);
        productList.add(product1);

        when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productService.getAllProducts();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void getProductByIdTest() {
        Long productId = 1L;
        Product product = new Product();
        product.setTitle("Test Product");
        product.setPrice(10.0);
        product.setDescription("Test description");
        product.setImage("test-image.jpg");

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Product result = productService.getProductById(productId);

        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo("Test Product");
        assertThat(result.getPrice()).isEqualTo(10.0);
        assertThat(result.getDescription()).isEqualTo("Test description");
        assertThat(result.getImage()).isEqualTo("test-image.jpg");
    }

    @Test
    public void saveCartTest() {
        Cart cartEntry = new Cart();
        cartEntry.setProductId(1L);
        cartEntry.setUser("johndoe");

        productService.saveCart(cartEntry);

        verify(cartRepository, times(1)).save(cartEntry);
    }


}