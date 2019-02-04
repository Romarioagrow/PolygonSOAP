package mybase.repos;
import org.springframework.data.repository.CrudRepository;
import mybase.entities.Message;
import mybase.entities.User;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
      List<Message> findByAuthor(User user);
}
