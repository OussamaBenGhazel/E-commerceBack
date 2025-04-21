package tn.esprit.Microservice_User.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tn.esprit.Microservice_User.role.Role;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails, Principal {

    @GeneratedValue
    @Id
    private Integer id;

    private String firstname;
    private String lastname;

    private LocalDate dateOfBirth;

    @Column(unique = true)
    private String email;

    private String password;

    private boolean enabled;

    private boolean accountLocked;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles", // Name of the join table
            joinColumns = @JoinColumn(name = "users_id"), // Foreign key in the join table referencing User
            inverseJoinColumns = @JoinColumn(name = "roles_id") // Foreign key in the join table referencing Role
    )
    private Set<Role> roles = new HashSet<>();// Use a mutable collection

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean deleted = false; // Default value

    // Getters and setters
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles.clear(); // Clear the existing roles
        this.roles.addAll(roles); // Add the new roles
    }

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @Override
    public String getName() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Map roles to GrantedAuthority
        return this.roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())) // Assuming Role has a `name` field
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String fullName() {
        return firstname + " " + lastname;
    }
}