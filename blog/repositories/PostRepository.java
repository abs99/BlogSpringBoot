package blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.entities.Category;
import blog.entities.Post;
import blog.entities.User;

public interface PostRepository extends JpaRepository<Post, Integer> {
 
	public List<Post> findAllByUser(User user);
	public List<Post> findByCategory(Category category);
	
}
