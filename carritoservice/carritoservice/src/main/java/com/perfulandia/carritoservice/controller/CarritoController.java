package com.perfulandia.carritoservice.controller;

import com.perfulandia.carritoservice.assembler.CarritoModelAssembler;
import com.perfulandia.carritoservice.model.Carrito;
import com.perfulandia.carritoservice.model.Notificacion;
import com.perfulandia.carritoservice.service.CarritoService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/carritos")
public class CarritoController {

    private final CarritoService carritoService;
    private final RestTemplate restTemplate;
    private final CarritoModelAssembler assembler;

    public CarritoController(CarritoService carritoService, RestTemplate restTemplate, CarritoModelAssembler assembler) {
        this.carritoService = carritoService;
        this.restTemplate = restTemplate;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Carrito>> obtenerTodos() {
        List<EntityModel<Carrito>> carritos = carritoService.obtenerTodos().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(carritos,
                linkTo(methodOn(CarritoController.class).obtenerTodos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Carrito> obtenerPorId(@PathVariable Long id) {
        Carrito carrito = carritoService.obtenerPorId(id);
        return assembler.toModel(carrito);
    }

    @PostMapping
    public EntityModel<Carrito> guardar(@RequestBody Carrito carrito) {
        Carrito savedCarrito = carritoService.guardar(carrito);

        // Enviar notificación al microservicio de notificaciones
        String mensaje = "Se creó tu carrito #" + savedCarrito.getId() + " con total $" + savedCarrito.getTotal();
        Notificacion notificacion = new Notificacion();
        notificacion.setUsuarioId(savedCarrito.getUsuarioId());
        notificacion.setCarritoId(savedCarrito.getId());
        notificacion.setMensaje(mensaje);

        restTemplate.postForObject("http://localhost:8084/api/notificaciones", notificacion, Notificacion.class);

        return assembler.toModel(savedCarrito);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        carritoService.eliminar(id);
    }
}
