package com.mitienda.apibazar.controlador;

import com.mitienda.apibazar.modelo.Producto;
import com.mitienda.apibazar.modelo.Venta;
import com.mitienda.apibazar.repository.RepositoryProducto;
import com.mitienda.apibazar.repository.RepositoryVenta;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@AllArgsConstructor
public class ControladorVenta {
    private  final RepositoryVenta repositoryVenta;
    private final RepositoryProducto repositoryProducto;
    @PostMapping("/crear")
    public Venta crear(@RequestBody Venta venta){
        return repositoryVenta.save(venta);

    }

    @GetMapping
    public List<Venta> listar(){
        List<Venta> ventas= repositoryVenta.findAll();
        return ventas;

    }

    @GetMapping("/{codigo_venta}")
    public Venta buscar(@PathVariable long codigo_venta){
        return repositoryVenta.findById(codigo_venta).orElse(null);


    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{codigo_venta}")
    public void eliminar(@PathVariable long codigo_venta){
        repositoryVenta.deleteById(codigo_venta);

    }
    @PutMapping("/{codigo_venta}")
    public Venta actualizar(@PathVariable long codigo_venta, @RequestBody Venta form){
        Venta venta=repositoryVenta.findById(codigo_venta).orElse(null);
        venta.setFecha_venta(form.getFecha_venta());
        venta.setTotal(form.getTotal());
        repositoryVenta.save(venta);
        return venta;

    }


}


}
