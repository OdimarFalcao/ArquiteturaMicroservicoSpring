package com.falcao.auth.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable, UserDetails {

    private static final long serialVersionUID = 840917418532642260L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name",unique = true)
    private String userName;

    @Column(name = "password")
    private String password;
    @Column(name = "accountNonExpired")
    private Boolean accountNonExpired;
    @Column(name = "accountNonLocked")
    private Boolean accountNonLocked;
    @Column(name = "credentialsNonExpired")
    private Boolean credentialsNonExpired;
    @Column(name = "enabled")
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_permission", joinColumns = {@JoinColumn(name = "id_user")}, inverseJoinColumns = {@JoinColumn(name = "id_permissions")} )
    private List<Permission> permissions;

    public List<String> getRoles(){
        List<String> roles = new ArrayList<>();
        this.permissions.stream()
                .forEach(permission -> {
                    roles.add(permission.getDescription());
                });

        return roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissions;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
