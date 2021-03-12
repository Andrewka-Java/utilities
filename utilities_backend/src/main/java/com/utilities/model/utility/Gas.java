/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.model.utility;

import com.utilities.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "gas")
@Getter
@Setter
public class Gas extends UtilityModel {

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_gas_user"),
            nullable = false
    )
    protected User user;

}
