package blog.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "catrgories")
@NoArgsConstructor
@Getter
@Setter
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer categoryId;
	
	@Column(name = "title", length = 100, nullable = false)
	public String categoryTitle;
	
	@Column(name = "description")
	public String categoryDescription;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	public List<Post> posts = new ArrayList<>();
	
}
