package org.iesvdm.jardineria.jardineria_jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.jardineria.jardineria_jpa.domain.Producto;
import org.iesvdm.jardineria.jardineria_jpa.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping(value = {"","/"})
    public List<Producto> all() {
        log.info("Accediendo a todas las películas");
        return this.productoService.all();
    }


    @PostMapping({"","/"})
    public Producto newProducto(@RequestBody Producto producto) {
        return this.productoService.save(producto);
    }

    @GetMapping("/{id}")
    public Producto one(@PathVariable("id") Long id) {
        return this.productoService.one(id);
    }

    @PutMapping("/{id}")
    public Producto replaceProducto(@PathVariable("id") Long id, @RequestBody Producto producto) {
        return this.productoService.replace(id, producto);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable("id") Long id) {
        this.productoService.delete(id);
    }
}
