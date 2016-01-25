package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends Model {

    @Id
    @Column(name="category_id")
    public Long id;
    @ManyToOne
    @JoinColumn(name="id")
    public User user;
    @Column(name="category")
    public String category;
    @Column(name="tags")
    public String tags;
    @CreatedTimestamp
    @Column(name="dt_create")
    @JsonIgnore
    public Date dtCreate;
    @Version
    @Column(name="dt_update")
    @JsonIgnore
    public Date dtUpdate;

    public static Model.Finder<Long, Category> find = new Finder<>(Long.class, Category.class);

    /**
     * Retrieve a User categories.
     */
    public static List<Category> findByUser(User user) {
        List<Category> categories = find.where().eq("user", user).findList();
        return categories;
    }

    /**
     * create new User category.
     */
    public static void create(Category category) {
        category.save();
    }

    /**
     * Update a User category.
     */
    public static void update(Category category) {
        category.update();
    }

    /**
     * Delete a User categories.
     */
    public static List<Category> deleteUserCategories(User user) {
        List<Category> categories = find.where().eq("user", user).findList();
        for(Category category : categories){
            category.delete();
        }
        return categories;
    }
}
