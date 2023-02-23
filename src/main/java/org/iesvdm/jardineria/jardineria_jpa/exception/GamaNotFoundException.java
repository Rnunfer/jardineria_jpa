package org.iesvdm.jardineria.jardineria_jpa.exception;

public class GamaNotFoundException extends RuntimeException{
    public GamaNotFoundException(Long id) { super("Not found Gama with id: " + id); }
}
