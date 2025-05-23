package tn.esprit.Microservice_User.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tn.esprit.Microservice_User.user.User;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)

public class Role {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name; // Ensure this matches the values in the database (e.g., "USER", "ADMIN", "AGENT")

    @ManyToMany(mappedBy = "roles" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> users;

    @CreatedDate
    @Column(updatable = false, nullable = false )
    private LocalDateTime createdAt ;
    @LastModifiedDate
    @Column(insertable = false )
    private LocalDateTime updatedAt ;



}
