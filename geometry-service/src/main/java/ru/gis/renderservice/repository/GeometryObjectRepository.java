package ru.gis.renderservice.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.gis.renderservice.domain.GeometryObject;


@Repository
public interface GeometryObjectRepository extends ReactiveCrudRepository<GeometryObject, Long> {

    @Query("INSERT INTO `geometry_object` (`id`, `geometry`, `color`) " +
            "VALUES (NULL, ST_GeomFromText(:geometry), :color)")
    Mono<GeometryObject> save(@Param("geometry") String geometry, @Param("color") String color);
}
