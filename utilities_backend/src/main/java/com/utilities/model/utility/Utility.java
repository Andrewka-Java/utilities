/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.model.utility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.utilities.model.ModelEntity;
import com.utilities.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "utility")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Utility extends ModelEntity implements Serializable {

    private static final long serialVersionUID = -7985364239114879677L;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "amount", nullable = false)
    private BigDecimal totalAmount;

    /**
     * JoinColumn - describes foreign key
     */
    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_utility_user"),
            nullable = false
    )
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "utility", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Water> waters;

    @JsonManagedReference
    @OneToMany(mappedBy = "utility", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Gas>gases;

    @JsonManagedReference
    @OneToMany(mappedBy = "utility", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Electricity> electricities;

}
