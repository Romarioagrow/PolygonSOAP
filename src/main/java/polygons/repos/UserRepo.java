package polygons.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import polygons.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
