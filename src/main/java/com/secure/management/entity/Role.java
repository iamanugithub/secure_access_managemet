package com.secure.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Role implements Serializable {

    @Id
    @Column(name = "role_id")
    private UUID rid;

    @Column(name = "role_name",unique = true)
    private String rName;

    @Column(name = "role_description")
    private String rDescription;

    @ManyToMany
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions = new HashSet<>();

    @ManyToMany(mappedBy = "groups")
    private Set<Group> groups = new HashSet<>();



}
