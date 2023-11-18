package com.ptsports.myproject.Service;



import com.ptsports.myproject.DTO.ImageProductDto;

import java.util.List;

public interface ImageProductService {
    ImageProductDto createImageProduct(ImageProductDto imageProductDto);
    void deleteImageProduct(Integer imageId);
    ImageProductDto updateImageProduct(ImageProductDto imageProductDto, Integer imageId);
    List<ImageProductDto> getAllImageForProduct(Integer productId);

}
