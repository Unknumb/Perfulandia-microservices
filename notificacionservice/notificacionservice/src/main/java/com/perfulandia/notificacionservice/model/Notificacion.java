package com.perfulandia.notificacionservice.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Schema(description = "Entidad que representa una notificacion de la tienda")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notificacion {
    @Schema(description = "ID autogenerado con Identity", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Schema(description = "id del usuario", example = "1")
    private Long usuarioId;
    @Schema(description = "id del carrito", example = "1")
    private Long carritoId;
    @Schema(description = "Texto de la notificacion", example = "Disfruta de tu compra!")
    private String mensaje;
}