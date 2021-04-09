/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.model;

import com.utilities.model.base.ModelEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "auth")
public class Auth extends ModelEntity implements Serializable {

    private static final long serialVersionUID = 3116697512003035333L;

    @Column(name = "access_token", nullable = false)
    private String accessToken;

    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @OneToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_auth_user"),
            nullable = false
    )
    private User user;

}
