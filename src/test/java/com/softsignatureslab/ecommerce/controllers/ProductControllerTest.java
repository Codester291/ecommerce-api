package com.softsignatureslab.ecommerce.controllers;

import com.google.gson.Gson;
import com.softsignatureslab.ecommerce.dto.product.ProductRequest;
import com.softsignatureslab.ecommerce.dto.product.ProductResponse;
import com.softsignatureslab.ecommerce.services.product.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProductControllerTest {

    MockMvc mockMvc;
    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;

    ProductRequest productRequest;

    Gson gson;
    ProductResponse productResponse;

    @BeforeEach
    void setUp() {
        gson = new Gson();
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();

        productRequest = new ProductRequest();
        productRequest.setName("Close Up");
        productRequest.setPrice(500.0);
        productRequest.setStockQuantity(5);
        productRequest.setDescription("It is a toothpaste");

        productResponse = new ProductResponse();
        productResponse.setId(1);
        productResponse.setName("Macbook Pro");
        productResponse.setPrice(3000000.0);
        productResponse.setDescription("Armed robber device");
        productResponse.setStockQuantity(2);
      }

    @Test
    void createProduct() throws Exception {
        when(productService.createProduct(productRequest)).thenReturn(productResponse);
        mockMvc.perform(post("/api/products/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(productRequest)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
      }

    @Test
    void getProducts() throws Exception {
        when(productService.getProducts()).thenReturn(List.of(productResponse));
        mockMvc.perform(get("/api/products/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
      }

    @Test
    void getProduct() throws Exception {
        when(productService.getProduct(anyInt())).thenReturn(productResponse);
        mockMvc.perform(get("/api/products/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
      }
}