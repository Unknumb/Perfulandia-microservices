package com.perfulandia.usuarioservice.controller;

import com.perfulandia.usuarioservice.assembler.UsuarioModelAssembler;
import com.perfulandia.usuarioservice.model.Carrito;
import com.perfulandia.usuarioservice.model.Usuario;
import com.perfulandia.usuarioservice.service.UsuarioService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;
    private final RestTemplate restTemplate;
    private final UsuarioModelAssembler assembler;

    public UsuarioController(UsuarioService service, RestTemplate restTemplate, UsuarioModelAssembler assembler) {
        this.service = service;
        this.restTemplate = restTemplate;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Usuario>> listar() {
        List<EntityModel<Usuario>> usuarios = service.listar().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(usuarios,
                linkTo(methodOn(UsuarioController.class).listar()).withSelfRel());
    }

    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    @GetMapping("/{id}")
    public EntityModel<Usuario> buscar(@PathVariable long id) {
        Usuario usuario = service.buscar(id);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        return assembler.toModel(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id) {
        service.eliminar(id);
    }

    @GetMapping("/carrito/{id}")
    public Carrito obtenerCarrito(@PathVariable long id) {
        return restTemplate.getForObject("http://localhost:8083/api/carritos/" + id, Carrito.class);
    }
}
