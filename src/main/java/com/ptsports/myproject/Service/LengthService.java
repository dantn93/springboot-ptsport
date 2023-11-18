package com.ptsports.myproject.Service;



import com.ptsports.myproject.DTO.LengthDto;
import com.ptsports.myproject.Entity.Length;

import java.util.List;

public interface LengthService {
    LengthDto createLength(LengthDto lengthDto);
    LengthDto updateLength(LengthDto lengthDto,Integer id);
    LengthDto getLengthById(Integer id);
    List<LengthDto> getAllLengths();
    void deleteLength(Integer id);
    void addLengthsService(List<Length> lengths);

    void deleteLengthsService(List<Integer> ids);
}
