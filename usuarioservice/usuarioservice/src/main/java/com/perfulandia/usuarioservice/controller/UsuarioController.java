package com.perfulandia.usuarioservice.controller;

import com.perfulandia.usuarioservice.model.Carrito;
import com.perfulandia.usuarioservice.model.Usuario;
import com.perfulandia.usuarioservice.repository.UsuarioRepository;
import com.perfulandia.usuarioservice.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;
    private final RestTemplate restTemplate;
    //Constructor para poder consumir la interfaz
    public UsuarioController(UsuarioService service, RestTemplate restTemplate) {
        this.service=service;
        this.restTemplate= restTemplate;
    }


    @Operation(summary = "Lista todos los usuarios")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Consulta exitosa"),
            @ApiResponse(responseCode = "400", description = "Error de validación")
    })
    @GetMapping
    public List<Usuario> listar(){
        return service.listar();
    }

    @Operation(summary = "Crea un nuevo usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuario creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Error de validación")
    })
    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario){
        return service.guardar(usuario);
    }

    @Operation(summary = "Busca un usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
            @ApiResponse(responseCode = "404", description = "Error de validación")
    })
    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable long id){
        return service.buscar(id);
    }

    @Operation(summary = "Elimina un usuario por el id")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuario eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Error de validación, Usuario no encontrado")
    })
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id){
        service.eliminar(id);
    }


    @Operation(summary = "Busca carrito por id ")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Carrito encontrado"),
            @ApiResponse(responseCode = "400", description = "Error de validación")
    })
    //Nuevo método
    @GetMapping("/carrito/{id}")
    public Carrito obtenerCarrito(@PathVariable long id){
        return restTemplate.getForObject("http://localhost:8083/api/carritos/"+id, Carrito.class);
    }



}
