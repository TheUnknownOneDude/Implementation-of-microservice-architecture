package ru.gis.renderservice.domain;

import lombok.*;
import org.locationtech.jts.geom.Geometry;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "geometry_object")
@Builder
public class GeometryObject {

    @Id
    private Long id;

    @Column("geometry")
    private String geometry;

    @Column("color")
    private String color;

}
