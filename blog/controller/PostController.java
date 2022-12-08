package blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import blog.payloads.PostDto;
import blog.services.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
		
	  @Autowired
	  PostService postService;
	  @PostMapping("/api")
	  public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
			  									@RequestParam Integer userId, 
			  									@RequestParam Integer categoryId){
		  PostDto newPostDto = postService.createPost(postDto, userId, categoryId);
		  
		  return new ResponseEntity<>(newPostDto, HttpStatus.CREATED) ;
	  }
	  
	  @GetMapping("/user/{userId}/posts")
	  public ResponseEntity<List<PostDto> > getPostsByUser(@PathVariable Integer userId){
		  
		  List<PostDto> posts = postService.getPostsByUser(userId);
		  
		  return new ResponseEntity<>(posts,HttpStatus.OK);
	  }
	  
	  @GetMapping("/category/{categoryId}/posts")
	  public ResponseEntity<List<PostDto> > getPostsByCategory(@PathVariable Integer categoryId){
		  
		  List<PostDto> posts = postService.getPostsByCategory(categoryId);
		  
		  return new ResponseEntity<>(posts,HttpStatus.OK);
	  }
	  
	  @PutMapping("/post/{postId}")
	  public ResponseEntity<PostDto> updatePost(@PathVariable Integer postId, @RequestBody PostDto PostDto){
		  
		  PostDto updatedPost = postService.updatePost(PostDto, postId);
		  return new ResponseEntity<>(updatedPost, HttpStatus.OK);
	  }
}
