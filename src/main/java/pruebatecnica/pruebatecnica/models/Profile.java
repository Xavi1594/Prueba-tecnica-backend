package pruebatecnica.pruebatecnica.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



@Entity
public class Profile {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String experience;
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getExperience() {
    return experience;
}
public void setExperience(String experience) {
    this.experience = experience;
}
public Profile() {
}
@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private User user;
@JoinColumn(name = "user_id", referencedColumnName = "id")

@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_courses", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;
}
