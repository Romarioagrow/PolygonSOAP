package polygons.repos;
import polygons.entities.api.VKUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VKRepo extends JpaRepository<VKUser, Long> {
}
