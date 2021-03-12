/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.model;

import com.utilities.model.utility.Electricity;
import com.utilities.model.utility.Gas;
import com.utilities.model.utility.Water;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends ModelEntity implements Serializable {

    private static final long serialVersionUID = 8630250366151711400L;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "bill", nullable = false)
    private BigDecimal bill;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Gas> gases;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Electricity> electricities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Water> waters;

    public User(final Integer id) {
        super(id);
    }

    public void setGases(final Set<Gas> gases) {
        if (gases != null) {
            gases.forEach(gas -> gas.setUser(this));
        }
        this.gases = gases;
    }

    public void setElectricities(final Set<Electricity> electricities) {
        if (electricities != null) {
            electricities.forEach(electricity -> electricity.setUser(this));
        }
        this.electricities = electricities;
    }

    public void setWaters(final Set<Water> waters) {
        if (waters != null) {
            waters.forEach(water -> water.setUser(this));
        }
        this.waters = waters;
    }

}

