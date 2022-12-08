package blog.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mysql.cj.callback.UsernameCallback;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
 
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 public Integer id;
 public String username;
 public String email;
 public String password;
 
 @OneToMany(mappedBy = "user")
 private List<Post> posts;
 
}
