package com.mitienda.apibazar.controlador;

import com.mitienda.apibazar.modelo.Cliente;
import com.mitienda.apibazar.modelo.Producto;
import com.mitienda.apibazar.repository.RepositoryProducto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ControladorProducto {
    private  final RepositoryProducto repositoryProducto;

    @PostMapping("/crear")
    public Producto crear(@RequestBody Producto producto){
        return repositoryProducto.save(producto);

    }

    @GetMapping
    public List<Producto> listar(){
        List<Producto> productos= repositoryProducto.findAll();
        return productos;

    }

    @GetMapping("/{codigo_producto}")
    public Producto buscar(@PathVariable long codigo_producto){
        return repositoryProducto.findById(codigo_producto).orElse(null);


    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{codigo_producto}")
    public void eliminar(@PathVariable long codigo_producto){
        repositoryProducto.deleteById(codigo_producto);

    }
    @PutMapping("/{codigo_producto}")
    public Producto actualizar(@PathVariable long codigo_producto, @RequestBody Producto form){
        Producto producto=repositoryProducto.findById(codigo_producto).orElse(null);
        producto.setNombre(form.getNombre());
        producto.setMarca(form.getMarca());
        producto.setCosto(form.getCosto());
        producto.setCantidaddisponible(form.getCantidaddisponible());
        repositoryProducto.save(producto);
        return producto;

    }
   @GetMapping("/falta_stock")
    public List<Producto> obtenerProductosConFaltaStock() {
        return repositoryProducto.findBycantidaddisponibleLessThan(5);
    }


}
