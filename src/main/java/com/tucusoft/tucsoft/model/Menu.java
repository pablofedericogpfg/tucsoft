package com.tucusoft.tucsoft.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Menu {
    private Integer id;
    private String menu;
    private String descripcion;
    private String destino;

}
