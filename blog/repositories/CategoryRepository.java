package blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
}
