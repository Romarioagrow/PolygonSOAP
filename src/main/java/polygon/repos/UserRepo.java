package polygon.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import polygon.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
