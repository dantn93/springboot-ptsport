package com.ptsports.myproject.Service;



import com.ptsports.myproject.DTO.PageDto;
import com.ptsports.myproject.DTO.ProductDto;
import com.ptsports.myproject.DTO.SearchDto;
import com.ptsports.myproject.Entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    ProductDto getProductById(Integer generalId);

    List<ProductDto> getAllProduct();

    ProductDto createProduct(ProductDto productDto) throws IOException;

    ProductDto updateProduct(ProductDto productDto, Integer generalId);

    void deleteProduct(Integer generalId);


    List<ProductDto> searchProductByName(String productName);

    PageDto<ProductDto> getProductsHomePage(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    List<ProductDto>search(SearchDto searchDto);

    List<ProductDto>filterByLength(int id);

    List<ProductDto>filterByCatalog(int id);

    Product convertToProduct(ProductDto productDto);

    ProductDto convertToProductDto(Product product);

    int count();
}
