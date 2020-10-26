package com.endava.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode(callSuper = true)
public class Discipline extends AbstractEntityId {

    private String name;

    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "discipline_id")
    private Set<User> members;

    @OneToOne
    @JoinColumn(name = "hod_id")
    private User hod;

}
