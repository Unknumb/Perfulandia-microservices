package com.perfulandia.carritoservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;

    @ElementCollection
    private List<Long> productoIds;

    private Double total;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public List<Long> getProductoIds() { return productoIds; }
    public void setProductoIds(List<Long> productoIds) { this.productoIds = productoIds; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
}
