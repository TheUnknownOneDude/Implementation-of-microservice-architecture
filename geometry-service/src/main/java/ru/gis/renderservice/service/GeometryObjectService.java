package ru.gis.renderservice.service;


import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Geometry;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.gis.renderservice.domain.GeometryObject;
import ru.gis.renderservice.repository.GeometryObjectRepository;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class GeometryObjectService {

    private final GeometryObjectRepository geometryObjectRepository;

    public void save(String geometry, String color) {
        geometryObjectRepository.save(geometry, color).subscribe();
    }

    public Flux<GeometryObject> findAll() {
        return geometryObjectRepository.findAll().delayElements(Duration.ofSeconds(1));
    }

    public Mono<GeometryObject> findById(Long id) {
        return geometryObjectRepository.findById(id);
    }

    public void deleteById(Long id) {
        geometryObjectRepository.deleteById(id).subscribe();
    }
}
