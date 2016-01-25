package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import helpers.utils.Password;
import play.db.ebean.Model;

@Entity
@Table(name = "users")
public class User extends Model {

	@Id
    @Column(name="id")
	public Long id;
    @Column(name="email", length = 100, unique = true)
    public String email;
    @Column(name="password")
    public String password;
    @Column(name="configured")
    public boolean configured;
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    public List<Category> categories;
    @CreatedTimestamp
    @Column(name="dt_create")
    @JsonIgnore
    public Date dtCreate;
    @Version
    @Column(name="dt_update")
    @JsonIgnore
    public Date dtUpdate;

    public User(){
        super();
    }
    public User(String email, String password) {
        super();
        this.email = email;
        this.password = password;
        this.configured = false;
        this.categories = new ArrayList<Category>();
    }

    public static Model.Finder<Long, User> find = new Finder<>(Long.class, User.class);

    /**
     * Authenticate a User.
     */
    public static User authenticate(String email, String password) {
        User user = findByEmail(email);
        if (user != null) {
            if (Password.check(user.password, password)) {
                return user;
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * Retrieve a User.
     */
    public static User findByEmail(String email) {
        User user = find.where().eq("email", email).findUnique();
        return user;
    }

    /**
     * create new User.
     */
    public static void create(User user) {
        user.save();
    }

    /**
     * Update User.
     */
    public static void update(User user) {
        user.update();
    }

}