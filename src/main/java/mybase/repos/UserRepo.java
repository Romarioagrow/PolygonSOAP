package mybase.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import mybase.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
