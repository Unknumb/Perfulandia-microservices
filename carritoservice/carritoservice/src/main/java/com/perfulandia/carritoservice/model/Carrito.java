package com.perfulandia.carritoservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Schema(description = "Entidad que representa un Carrito de la tienda")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carrito {
    @Schema(description = "ID autogenerado con Identity", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Nombre del usuario relaciono al carrito", example = "juani")
    private long usuarioId;

    @Schema(description = " Cantidad total de productos en el carrito", example = "20")
    @ElementCollection
    private List<Long> productoIds;

    @Schema(description = " Total del precio del Carrito", example = "20000")
    private Double total;

}

