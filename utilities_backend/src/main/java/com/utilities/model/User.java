/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.model;

import com.utilities.model.utility.Utility;
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

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "bill", nullable = false)
    private BigDecimal bill;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Utility> utilities;

    public User(final Integer id) {
        super(id);
    }

    public void setUtilities(final Set<Utility> utilities) {
        if (utilities != null) {
            utilities.forEach(utility -> utility.setUser(this));
        }
        this.utilities = utilities;
    }

}

