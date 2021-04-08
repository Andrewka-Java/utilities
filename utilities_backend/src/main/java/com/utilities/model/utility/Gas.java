/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.model.utility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.utilities.model.ModelEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "gas")
@Getter
@Setter
public class Gas extends ModelEntity implements Serializable {

    private static final long serialVersionUID = -374582317990741469L;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @JsonBackReference
    @OneToOne
    @JoinColumn(
            name = "utility_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_gas_utility"),
            nullable = false
    )
    protected Utility utility;

}
