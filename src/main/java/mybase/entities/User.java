package mybase.entities;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mybase.entities.vk.VKUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import mybase.repos.Role;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude="messages")
@NoArgsConstructor
@Table(name = "usr")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;
    private String username;
    private String password;
    private boolean active;
    private LocalDateTime registrationDate;

    public User(String username, String password, LocalDateTime registrationDate) {
        this.username = username;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    private Set<Message> messages;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vk_id")
    private List<VKUser> VK_profile;*/

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }
    public boolean isUser() { return roles.contains(Role.USER);}
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return isActive();
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    private boolean isActive() {
        return active;
    }

    /*public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public Set<Message> getMessages() {
        return messages;
    }
    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
    public <T> void setRoles(Set<T> singleton, Set<T> singleton1) {
    }
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }*/
}