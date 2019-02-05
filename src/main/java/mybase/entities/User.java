package mybase.entities;
import mybase.entities.vk.VKUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import mybase.repos.Role;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    private String username;
    private String password;
    private boolean active;

    public User(String username, String password, LocalDateTime registrationDate) {
        this.username = username;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    private LocalDateTime registrationDate;

    // Автоподгрузка полей сразу
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    // Создать собственную таблицу для ролей и связать ее с текущей через столбец user_id
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    // Сообщения пользователя
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    private Set<Message> messages;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private List<VKUser> VK_profile;


    //////////////////////////////////
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {}

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

    public long getId() {
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

    public boolean isActive() {
        return active;
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
    }

}