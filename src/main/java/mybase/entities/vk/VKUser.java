package mybase.entities.vk;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VK_profile")
public class VKUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long profile_id;

    @JoinColumn(name = "user_id")
    private Long user_id;

    private String firstName;
    private String lastName;
    private String city;
    private Integer age;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "friends_list_id")
    private VKFriendsList vkfriends;

    public VKFriendsList getVkfriends() {
        return vkfriends;
    }

    public void setVkfriends(VKFriendsList vkfriends) {
        this.vkfriends = vkfriends;
    }*/

    public VKUser() {
    }

    public Long getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Long profile_id) {
        this.profile_id = profile_id;
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