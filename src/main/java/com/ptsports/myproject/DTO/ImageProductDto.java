package com.ptsports.myproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ImageProductDto implements Serializable {
    private  Integer id;
    private String title;
    private String path;
}
