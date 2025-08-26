package com.secure.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Group implements Serializable {

    @Id
    @Column(name = "group_id")
    private UUID gid;

    @Column(name = "group_name",unique = true)
    private String gName;

    @Column(name = "group_description")
    private String gDescription;

    @ManyToMany
    @JoinTable(
            name = "group_roles",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles ;

    @ManyToMany(mappedBy = "users")
    private Set<User> users = new HashSet<>();


}
