package tn.esprit.Microservice_User.auth;

import lombok.RequiredArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Microservice_User.role.Role;
import tn.esprit.Microservice_User.role.RoleName;
import tn.esprit.Microservice_User.role.RoleRepository;
import tn.esprit.Microservice_User.user.User;
import tn.esprit.Microservice_User.user.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/auth/admin")
@RequiredArgsConstructor

public class AdminController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    /**
     * Fetch all users.
     * Accessible only by admins.
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    /**
     * Update a user's role.
     * Accessible only by admins.
     */
    @PutMapping("/users/{userId}/role")
    public ResponseEntity<String> updateUserRole(
            @PathVariable Integer userId,
            @RequestParam String roleName
    ) {
        // Fetch the user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch the role
        Role role = roleRepository.findByName(String.valueOf(RoleName.valueOf(roleName.toUpperCase())))
                .orElseThrow(() -> new RuntimeException("Role not found"));

        // Update the user's roles
        Set<Role> updatedRoles = new HashSet<>(); // Use a mutable set
        updatedRoles.add(role);
        user.setRoles(updatedRoles);
        userRepository.save(user);

        return ResponseEntity.ok("User role updated successfully!");
    }

    /**
     * Delete a user.
     * Accessible only by admins.
     */
    @DeleteMapping(value = "/users/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId, KeycloakAuthenticationToken auth) {
        KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
        KeycloakSecurityContext context = principal.getKeycloakSecurityContext();
        boolean hasUserRole = context.getToken().getRealmAccess().isUserInRole("ADMIN");
        if (hasUserRole) {
            // Check if the user exists
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Delete the user
            userRepository.delete(user);

            return ResponseEntity.ok("User deleted successfully!");
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}