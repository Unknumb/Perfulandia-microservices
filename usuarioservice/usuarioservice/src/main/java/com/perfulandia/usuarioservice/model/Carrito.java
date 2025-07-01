package com.perfulandia.usuarioservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.*;

import java.util.List;

//dto
@Schema(description = "Entidad que representa al carrito desde usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrito {

    private long id;
    private long usuarioId;
    private List<Long> productoIds;
    private Double total;

}
