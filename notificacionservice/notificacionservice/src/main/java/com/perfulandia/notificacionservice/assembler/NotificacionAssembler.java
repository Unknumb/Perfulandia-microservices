
package com.perfulandia.notificacionservice.assembler;

import com.perfulandia.notificacionservice.controller.NotificacionController;
import com.perfulandia.notificacionservice.model.Notificacion;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class NotificacionAssembler implements RepresentationModelAssembler<Notificacion, EntityModel<Notificacion>> {

    @Override
    public EntityModel<Notificacion> toModel(Notificacion notificacion) {
        return EntityModel.of(notificacion,
                linkTo(methodOn(NotificacionController.class).obtenerPorId(notificacion.getId())).withSelfRel(),
                linkTo(methodOn(NotificacionController.class).obtenerTodas()).withRel("notificaciones"),
                linkTo(methodOn(NotificacionController.class).eliminar(notificacion.getId())).withRel("eliminar"),
                linkTo(methodOn(NotificacionController.class).obtenerNotificacionConCarrito(notificacion.getId())).withRel("detalle-carrito")
        );
    }
}
