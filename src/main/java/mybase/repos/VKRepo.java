package mybase.repos;
import mybase.entities.vk.VKUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VKRepo extends JpaRepository<VKUser, Long> {
    VKUser findByFirstName(String firstName);
}
