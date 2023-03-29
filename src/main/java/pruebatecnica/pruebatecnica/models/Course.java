package pruebatecnica.pruebatecnica.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {

    public Course() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String courseName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    Set<Profile> profiles;
}
