package com.mitienda.apibazar.controlador;


import com.mitienda.apibazar.modelo.Cliente;
import com.mitienda.apibazar.repository.RepositoryCliente;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ControladorCliente {

    private final RepositoryCliente repositoryCliente;



    @PostMapping("/crear")
    public Cliente crear(@RequestBody Cliente cliente){
        return repositoryCliente.save(cliente);

    }

    @GetMapping
    public List<Cliente> listar(){
        List<Cliente> clientes= repositoryCliente.findAll();
        return clientes;

    }

    @GetMapping("/{id_cliente}")
    public Cliente buscar(@PathVariable long id_cliente){
        return repositoryCliente.findById(id_cliente).orElse(null);


    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id_cliente}")
    public void eliminar(@PathVariable long id_cliente){
       repositoryCliente.deleteById(id_cliente);

    }
    @PutMapping("/{id_cliente}")
    public Cliente actualizar(@PathVariable long id_cliente, @RequestBody Cliente form){
        Cliente cliente=repositoryCliente.findById(id_cliente).orElse(null);
        cliente.setNombre(form.getNombre());
        cliente.setApellido(form.getApellido());
        cliente.setDni(form.getDni());
        repositoryCliente.save(cliente);
        return cliente;

    }

}
