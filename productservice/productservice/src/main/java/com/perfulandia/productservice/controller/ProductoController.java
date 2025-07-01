package com.perfulandia.productservice.controller;
import com.perfulandia.productservice.model.Usuario;
import com.perfulandia.productservice.model.Producto;
import com.perfulandia.productservice.model.Carrito;
import com.perfulandia.productservice.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Nuevas importaciones DTO conexión al MS usuario
import org.springframework.web.client.RestTemplate;
//Para hacer peticiones HTTP a otros microservicios.


@RestController
@RequestMapping("/api/productos")
public class ProductoController {



    private final ProductoService servicio;
    private final RestTemplate restTemplate;
    //final: oye esto no lo toques
    public ProductoController(ProductoService servicio,  RestTemplate restTemplate){
        this.servicio = servicio;
        this.restTemplate = restTemplate;
    }

    //listar
    @Operation(summary = "Lista todos los productos de la tienda")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Consulta exitosa"),
            @ApiResponse(responseCode = "400", description = "Error de validación")
    })
    @GetMapping
    public List<Producto> listar(){
        return servicio.listar();
    }
    //guardar
    @Operation(summary = "Guarda un producto")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Perfume guardado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Error de validación")
    })
    @PostMapping
    public Producto guardar(@RequestBody Producto producto){
        return servicio.guardar(producto);
    }
    //buscar x id
    @Operation(summary = "Busca un producto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Perfume encontrado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error de validación")
    })
    @GetMapping("/{id}")
    public Producto buscar(@PathVariable long id){
        return servicio.bucarPorId(id);
    }


    //Eliminar
    @Operation(summary = "Elimina un producto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Perfume eliminado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error de validación")
    })
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id){
        servicio.eliminar(id);
    }

    @Operation(summary = "Busca un usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Consulta exitosa"),
            @ApiResponse(responseCode = "400", description = "Error de validación")
    })
    //Nuevo método
    @GetMapping("/usuario/{id}")
    public Usuario obtenerUsuario(@PathVariable long id){
        return restTemplate.getForObject("http://localhost:8081/api/usuarios/"+id,Usuario.class);
    }
    //Nuevo
    @Operation(summary = "Busca un carrito")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Consulta exitosa"),
            @ApiResponse(responseCode = "400", description = "Error de validación")
    })
    @GetMapping("/carrito/{id}")
    public Carrito obtenerCarrito(@PathVariable long id){
        return restTemplate.getForObject("http://localhost:8083/api/carritos/"+id, Carrito.class);
    }


}
