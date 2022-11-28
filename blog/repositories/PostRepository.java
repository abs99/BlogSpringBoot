package blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
 
	
	
}
