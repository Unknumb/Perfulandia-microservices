package com.perfulandia.notificacionservice.controller;

import com.perfulandia.notificacionservice.model.Carrito;
import com.perfulandia.notificacionservice.model.Notificacion;
import com.perfulandia.notificacionservice.service.NotificacionService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionService notificacionService;
    private final RestTemplate restTemplate;

    public NotificacionController(NotificacionService notificacionService, RestTemplate restTemplate) {
        this.notificacionService = notificacionService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public CollectionModel<EntityModel<Notificacion>> obtenerTodas() {
        List<EntityModel<Notificacion>> notificaciones = notificacionService.obtenerTodas().stream()
                .map(notificacion -> EntityModel.of(notificacion,
                        linkTo(methodOn(NotificacionController.class).obtenerPorId(notificacion.getId())).withSelfRel(),
                        linkTo(methodOn(NotificacionController.class).eliminar(notificacion.getId())).withRel("eliminar"),
                        linkTo(methodOn(NotificacionController.class).obtenerNotificacionConCarrito(notificacion.getId())).withRel("detalle-carrito")
                ))
                .collect(Collectors.toList());

        return CollectionModel.of(notificaciones,
                linkTo(methodOn(NotificacionController.class).obtenerTodas()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Notificacion> obtenerPorId(@PathVariable Long id) {
        Notificacion notificacion = notificacionService.obtenerPorId(id);

        return EntityModel.of(notificacion,
                linkTo(methodOn(NotificacionController.class).obtenerPorId(id)).withSelfRel(),
                linkTo(methodOn(NotificacionController.class).obtenerTodas()).withRel("todas"),
                linkTo(methodOn(NotificacionController.class).eliminar(id)).withRel("eliminar"),
                linkTo(methodOn(NotificacionController.class).obtenerNotificacionConCarrito(id)).withRel("detalle-carrito")
        );
    }

    @PostMapping
    public EntityModel<Notificacion> guardar(@RequestBody Notificacion notificacion) {
        Notificacion nuevaNotificacion = notificacionService.guardar(notificacion);

        return EntityModel.of(nuevaNotificacion,
                linkTo(methodOn(NotificacionController.class).obtenerPorId(nuevaNotificacion.getId())).withSelfRel(),
                linkTo(methodOn(NotificacionController.class).obtenerTodas()).withRel("todas")
        );
    }

    @DeleteMapping("/{id}")
    public EntityModel<String> eliminar(@PathVariable Long id) {
        notificacionService.eliminar(id);
        return EntityModel.of("Notificación eliminada",
                linkTo(methodOn(NotificacionController.class).obtenerTodas()).withRel("todas"));
    }

    @GetMapping("/detallada/{id}")
    public EntityModel<Map<String, Object>> obtenerNotificacionConCarrito(@PathVariable Long id) {
        Notificacion notificacion = notificacionService.obtenerPorId(id);
        Carrito carrito = restTemplate.getForObject(
                "http://localhost:8083/api/carritos/" + notificacion.getCarritoId(),
                Carrito.class
        );

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("notificacion", notificacion);
        respuesta.put("carrito", carrito);

        return EntityModel.of(respuesta,
                linkTo(methodOn(NotificacionController.class).obtenerPorId(id)).withRel("notificacion"),
                linkTo(methodOn(NotificacionController.class).obtenerTodas()).withRel("todas"));
    }
}
