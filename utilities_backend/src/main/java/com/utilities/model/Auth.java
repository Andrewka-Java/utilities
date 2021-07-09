/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.utilities.model.base.ModelEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "auth")
public class Auth extends ModelEntity implements Serializable {

    private static final long serialVersionUID = 3116697512003035333L;

    @NonNull
    @Column(name = "access_token", nullable = false)
    private String accessToken;

    @NonNull
    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;

    @NonNull
    @Column(name = "active", nullable = false)
    private Boolean active;

    @JsonBackReference
    @OneToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_auth_user"),
            nullable = false
    )
    private User user;

}
