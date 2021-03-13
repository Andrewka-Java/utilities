/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.model.utility;

import com.utilities.model.ModelEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "electricity")
@Getter
@Setter
public class Electricity extends ModelEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "amount")
    private BigDecimal amount;

    @OneToOne
    @JoinColumn(
            name = "utility_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_electricity_utility"),
            nullable = false
    )
    protected Utility utility;

}
