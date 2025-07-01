package com.perfulandia.productservice.model;

import jakarta.persistence.*;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Entidad que representa un un producto de perfulandia")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    @Schema(description = "ID autogenerado con Identity", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Schema(description = "Nombre del Perfume", example = "Maison Margiela Replica - By the fireplace")
    private String nombre;

    @Schema(description = " Cantidad total de unidades de este videojuego", example = "20")
    private double precio;

    @Schema(description = "Stock del perfume", example = "5")
    private int stock;

}

