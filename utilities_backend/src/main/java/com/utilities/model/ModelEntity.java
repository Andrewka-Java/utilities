/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;


@NoArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public ModelEntity(final Integer id) {
        this.id = id;
    }

}
