package com.perfulandia.notificacionservice.controller;

import com.perfulandia.notificacionservice.model.Carrito;
import com.perfulandia.notificacionservice.model.Notificacion;
import com.perfulandia.notificacionservice.service.NotificacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionService notificacionService;
    private final RestTemplate restTemplate;

    public NotificacionController(NotificacionService notificacionService, RestTemplate restTemplate) {
        this.notificacionService = notificacionService;
        this.restTemplate = restTemplate;
    }


    //Operation: para documentar endpoints espeificos o metodos
    @Operation(summary = "Obtener todas las notificaciones enviadas", description = "Devuelve una lista con todos " +
            "las notificaciones ")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa")//Sirve para documentar las respuestas esperadas
    @GetMapping
    public List<Notificacion> obtenerTodas() {
        return notificacionService.obtenerTodas();
    }


    @Operation(summary = "Obtiene las notificaciones al id correspondiente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Consulta correcta"),
            @ApiResponse(responseCode = "400", description = "Error de validación")
    })
    @GetMapping("/{id}")
    public Notificacion obtenerPorId(@PathVariable Long id) {
        return notificacionService.obtenerPorId(id);
    }


    @Operation(summary = "Guardar una notificacion")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "La notificion fue guardada con exito"),
            @ApiResponse(responseCode = "404", description = "Error de validacion")
    })
    @PostMapping
    public Notificacion guardar(@RequestBody Notificacion notificacion) {
        return notificacionService.guardar(notificacion);
    }

    @Operation(summary = "Eliminar una notificacion")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "La notificacion fue eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "No existe el id de la notificacion")
    })
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        notificacionService.eliminar(id);
    }



    @Operation(summary = "Obtiene una notificacion desde el carrito")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Consulta exitosa"),
            @ApiResponse(responseCode = "404", description = "No existe el id de la notificacion")
    })
    @GetMapping("/detallada/{id}")
    public Map<String, Object> obtenerNotificacionConCarrito(@PathVariable Long id) {
        Notificacion notificacion = notificacionService.obtenerPorId(id);
        Carrito carrito = restTemplate.getForObject(
                "http://localhost:8083/api/carritos/" + notificacion.getCarritoId(),
                Carrito.class
        );
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("notificacion", notificacion);
        respuesta.put("carrito", carrito);
        return respuesta;
    }
}
