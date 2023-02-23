package org.iesvdm.jardineria.jardineria_jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.jardineria.jardineria_jpa.domain.Gama;
import org.iesvdm.jardineria.jardineria_jpa.service.GamaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/gamas")
public class GamaController {

    private final GamaService gamaService;

    public GamaController(GamaService gamaService) {
        this.gamaService = gamaService;
    }

    @GetMapping(value = {"","/"})
    public List<Gama> all() {
        log.info("Accediendo a todas las películas");
        return this.gamaService.all();
    }


    @PostMapping({"","/"})
    public Gama newGama(@RequestBody Gama gama) {
        return this.gamaService.save(gama);
    }

    @GetMapping("/{id}")
    public Gama one(@PathVariable("id") Long id) {
        return this.gamaService.one(id);
    }

    @PutMapping("/{id}")
    public Gama replaceGama(@PathVariable("id") Long id, @RequestBody Gama gama) {
        return this.gamaService.replace(id, gama);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteGama(@PathVariable("id") Long id) {
        this.gamaService.delete(id);
    }
}
