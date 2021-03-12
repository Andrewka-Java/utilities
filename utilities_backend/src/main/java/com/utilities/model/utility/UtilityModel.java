/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.model.utility;

import com.utilities.model.ModelEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class UtilityModel extends ModelEntity {

    @Column(name = "date", nullable = false)
    protected LocalDate date;

    @Column(name = "amount", nullable = false)
    protected BigDecimal amount;

}
