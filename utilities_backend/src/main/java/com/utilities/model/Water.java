/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.utilities.model.base.ModelEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "water")
@Getter
@Setter
public class Water extends ModelEntity implements Serializable {

    private static final long serialVersionUID = 8155659653441098745L;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @JsonBackReference
    @OneToOne
    @JoinColumn(
            name = "utility_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_water_utility"),
            nullable = false
    )
    protected Utility utility;

}
