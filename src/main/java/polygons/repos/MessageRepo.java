package polygons.repos;
import org.springframework.data.repository.CrudRepository;
import polygons.entities.Message;
import polygons.entities.User;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
      List<Message> findByAuthor(User user);
}
