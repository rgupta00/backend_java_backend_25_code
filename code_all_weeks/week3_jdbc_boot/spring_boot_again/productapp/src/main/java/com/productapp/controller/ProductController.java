package com.productapp.controller;

import com.productapp.dto.ProductDto;
import com.productapp.entities.Product;
import com.productapp.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@ResponseBody: parser in our classpath: jackson parser
@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //ResponseEntity: HTTP status code + data

    //get all
    @GetMapping("products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts());
    }

    //get by id
    @Operation(
            summary = "Retrieve a Product by Id",
            description = "Get a Product object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Product.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
      @GetMapping("products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
    }

    //add product
    @PostMapping("products")
    public ResponseEntity<ProductDto> addProduct(@RequestBody @Valid ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productDto));
    }

    //update product
    @PutMapping("products/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable int id,
                                 @RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, productDto));
    }

    //remove product
    @DeleteMapping("products/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable int id) {
        productService.removeProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
