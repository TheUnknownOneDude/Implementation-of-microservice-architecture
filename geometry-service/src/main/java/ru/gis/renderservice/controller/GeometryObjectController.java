package ru.gis.renderservice.controller;

import lombok.RequiredArgsConstructor;
import net.sf.jsqlparser.util.validation.ValidationException;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKTReader;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.gis.renderservice.domain.GeometryObject;
import ru.gis.renderservice.service.GeometryObjectService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/1/geometry")
@RequiredArgsConstructor
public class GeometryObjectController {

    private final GeometryObjectService geometryObjectService;

    @PostMapping("/create")
    public void createGeometry(@RequestParam String geometry, @RequestParam String color) {

        if (!isValidHexaCode(color)) {
            throw new ValidationException("Wrong color pattern");
        }

        WKTReader wktReader = new WKTReader();

        try {
            Geometry geometryObj = wktReader.read(geometry);
            geometryObjectService.save(geometry, color);
        } catch (Exception e) {
            throw new ValidationException("Geometry has to be in a WKT format");
        }
    }

    @GetMapping("/findAll")
    public Flux<GeometryObject> findAll() {
        return geometryObjectService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<GeometryObject> findById(@PathVariable Long id) {
        return geometryObjectService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        geometryObjectService.deleteById(id);
    }

    public boolean isValidHexaCode(String color) {

        String regex = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

        Pattern p = Pattern.compile(regex);

        if (color == null) {
            return false;
        }

        Matcher m = p.matcher(color);

        return m.matches();
    }
}

