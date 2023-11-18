package com.ptsports.myproject.Service;


import com.ptsports.myproject.DTO.SizeDto;
import com.ptsports.myproject.Entity.Size;

import java.util.List;

public interface SizeService {
    SizeDto createSize(SizeDto sizeDto);
    SizeDto updateSize(SizeDto sizeDto,Integer sizeId);
    SizeDto getSizeById(Integer sizeId);
    List<SizeDto> getAllSize();
    void deleteSize(Integer sizeId);
    SizeDto convertToSizeDto(Size size);
    Size convertToSize(SizeDto sizeDto);
    void addSizesService(List<Size> sizes);

    void deleteSizesService(List<Integer> ids);

}