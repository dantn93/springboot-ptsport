package com.ptsports.myproject.Service;



import com.ptsports.myproject.DTO.CatalogDto;
import com.ptsports.myproject.Entity.Catalog;

import java.util.List;

public interface CatalogService {
    CatalogDto createCatalog(CatalogDto catalogDto);
    CatalogDto updateCatalog(CatalogDto catalogDto,Integer catelogId);
    CatalogDto getCatalogById(Integer catelogId);
    List<CatalogDto> getAllCatalogs();
    void deleteCatalog(Integer catelogId);
    void addCatalogsService(List<Catalog> catalogs);

    void deleteCatalogsService(List<Integer> ids);

}
