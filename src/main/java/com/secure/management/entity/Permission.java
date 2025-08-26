package com.secure.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "permissions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Permission {

    @Id
    @Column(name = "permission_id")
    private UUID pid;

    @Column(name = "permission_name",unique = true)
    private String pName;

    @Column(name = "permission_description")
    private String pDescription;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();
}
