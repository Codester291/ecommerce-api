package com.softsignatureslab.ecommerce.services.product;

import com.softsignatureslab.ecommerce.dto.product.ProductRequest;
import com.softsignatureslab.ecommerce.dto.product.ProductResponse;

import java.util.List;
public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
    List<ProductResponse> getProducts();
    ProductResponse getProduct(int productId);
}
