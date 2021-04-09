/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.utilities.model.base.ModelEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends ModelEntity implements Serializable {

    private static final long serialVersionUID = 8630250366151711400L;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "bill", nullable = false)
    private BigDecimal bill;

    /**
     *mappedBy - for non-general entity
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Utility> utilities;


    public User(final Integer id) {
        super(id);
    }

}

