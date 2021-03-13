/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.model.utility;

import com.utilities.model.ModelEntity;
import com.utilities.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "utility")
@Getter
@Setter
@ToString
public class Utility extends ModelEntity {

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "amount", nullable = false)
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_utility_user"),
            nullable = false
    )
    private User user;

}
