package polygons.entities.api;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "google_usr")
public class GoogleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long google_id;

    @JoinColumn(name = "user_id")
    private Long user_id;

    private String name;
    private String userpic;
    private String email;
    private String gender;
    private String locale;
    private LocalDateTime lastVisit;

    public GoogleUser() {
    }

    public Long getGoogle_id() {
        return google_id;
    }

    public void setGoogle_id(Long google_id) {
        this.google_id = google_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public LocalDateTime getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDateTime lastVisit) {
        this.lastVisit = lastVisit;
    }
}
