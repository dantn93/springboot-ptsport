package com.ptsports.myproject.DTO;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class CatalogDto implements Serializable {
    private Integer catalogId;
    private String catalogName;
}
