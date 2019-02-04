package mybase.entities;
import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;
    private String tag;
    private String filename;

    // Подключать автора сразу
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    // Проверка автора сообщения
    public String getAuthorName() {
        return author !=null ? author.getUsername() : "unknown";
    }

    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Message() {}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public boolean hasTag() {
        return this.tag != null && !this.tag.isEmpty();
    }
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }
}
