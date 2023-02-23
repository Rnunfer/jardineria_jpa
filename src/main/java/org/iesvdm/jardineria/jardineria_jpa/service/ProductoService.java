package org.iesvdm.jardineria.jardineria_jpa.service;

import org.iesvdm.jardineria.jardineria_jpa.domain.Producto;
import org.iesvdm.jardineria.jardineria_jpa.exception.ProductoNotFoundException;
import org.iesvdm.jardineria.jardineria_jpa.repository.ProductoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> all() {
        return this.productoRepository.findAll();
    }

    public Producto save(Producto producto) {
        return this.productoRepository.save(producto);
    }

    public Producto one(Long id) {
        return this.productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    public Producto replace(Long id, Producto producto) {

        return this.productoRepository.findById(id).map( p -> (id.equals(producto.getCodigo_producto())  ?
                        this.productoRepository.save(producto) : null))
                .orElseThrow(() -> new ProductoNotFoundException(id));

    }

    public void delete(Long id) {
        this.productoRepository.findById(id).map(p -> {this.productoRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }
}
