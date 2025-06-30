package com.perfulandia.carritoservice.assembler;

import com.perfulandia.carritoservice.controller.CarritoController;
import com.perfulandia.carritoservice.model.Carrito;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CarritoModelAssembler implements RepresentationModelAssembler<Carrito, EntityModel<Carrito>> {

    @Override
    public EntityModel<Carrito> toModel(Carrito carrito) {
        return EntityModel.of(carrito,
                linkTo(methodOn(CarritoController.class).obtenerPorId(carrito.getId())).withSelfRel(),
                linkTo(methodOn(CarritoController.class).obtenerTodos()).withRel("carritos"));
    }
}
