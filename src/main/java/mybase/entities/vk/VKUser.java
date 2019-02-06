package mybase.entities.vk;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "vk_usr")
public class VKUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vk_id;

    @JoinColumn(name = "user_id")
    private Long user_id;

    private String firstName;
    private String lastName;
    private String city;
    private Integer age;

    // Список друзей пользователя
    @ManyToMany
    @JoinTable(name="vk_friends",
            joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="friendId")
    )
    private List<VKUser> friendsList;

    // Пользователь является одним из друзей у пользователя Х
    @ManyToMany
    @JoinTable(name="vk_friends",
            joinColumns=@JoinColumn(name="friendId"),
            inverseJoinColumns=@JoinColumn(name="userId")
    )
    private List<VKUser> friendOf;

    // Подписчики пользователя
    /*@ManyToMany
    @JoinTable(name="vk_followers",
            joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="followerId")
    )
    private List<VKUser> followersList; // дружит с

    // Подписки ползьователя
    @ManyToMany
    @JoinTable(name="vk_followers",
            joinColumns=@JoinColumn(name="followerId"),
            inverseJoinColumns=@JoinColumn(name="userId")
    )
    private List<VKUser> following; // является другом для*/


    public List<VKUser> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<VKUser> friendsList) {
        this.friendsList = friendsList;
    }

    public List<VKUser> getFriendOf() {
        return friendOf;
    }

    public void setFriendOf(List<VKUser> friendOf) {
        this.friendOf = friendOf;
    }

    /*public List<VKUser> getFollowersList() {
        return followersList;
    }

    public void setFollowersList(List<VKUser> followersList) {
        this.followersList = followersList;
    }

    public List<VKUser> getFollowing() {
        return following;
    }

    public void setFollowing(List<VKUser> following) {
        this.following = following;
    }*/

    public VKUser() {
    }

    public Long getVk_id() {
        return vk_id;
    }

    public void setVk_id(Long vk_id) {
        this.vk_id = vk_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}