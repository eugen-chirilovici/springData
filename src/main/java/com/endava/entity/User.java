package com.endava.entity;

import com.endava.entity.annotations.SortPageField;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntityId{

    private String fName;

    private String lName;

    @SortPageField
    private String email;

    private String userName;

    private LocalDate createdAt;

    private boolean enable;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Set<Task> tasks;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

}
