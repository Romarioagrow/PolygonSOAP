package polygon.repos;
import org.springframework.data.repository.CrudRepository;
import polygon.entities.Message;
import polygon.entities.User;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
      List<Message> findByAuthor(User user);
}
