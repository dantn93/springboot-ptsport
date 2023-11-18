package com.ptsports.myproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SizeDto implements Serializable {
    private  Integer id;
    private String name;
}
