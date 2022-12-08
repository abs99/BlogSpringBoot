package blog.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import blog.entities.Category;
import blog.entities.Post;
import blog.entities.User;
import blog.payloads.PostDto;
import blog.repositories.CategoryRepository;
import blog.repositories.PostRepository;
import blog.repositories.UserRepo;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepo;
	
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
		Post post = modelMapper.map(postDto, Post.class);
		User user =  userRepo.findById(userId).get();
		Category category = catRepo.findById(categoryId).get();
		post.setAddedDate(new Date());
		post.setCategory(category);
		post.setUser(user);	
	  
		Post newPost = postRepo.save(post);
		  System.out.println(modelMapper.map(newPost, PostDto.class));
		return modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
		PostDto updatedPost = new PostDto();
		try {
			 Post post = postRepo.findById(postId).get();
			 post.setTitle(postDto.getTitle());
			 post.setImage(postDto.getImage());
			 post.setContent(postDto.getContent());
			 postRepo.save(post);
			 updatedPost = modelMapper.map(post, PostDto.class);
			
		} catch (Exception e) {
			throw e;
		}
		return updatedPost;
	}

	@Override
	public PostDto getPost(PostDto postDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto deletePost(PostDto postDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 public List<PostDto> getPostsByUser(Integer userId){
		 List<PostDto> postDtoList = new ArrayList<PostDto>();
		 User user = userRepo.findById(userId).get();
		 List<Post> posts = this.postRepo.findAllByUser(user);
		 postDtoList = posts.stream().map((post)->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		 return postDtoList;
		 
		 
	 }
	 
	 
    public List<PostDto> getPostsByCategory(Integer categoryId){
    	 List<PostDto> postDtoList = new ArrayList<PostDto>();
		 Category category = catRepo.findById(categoryId).get();
		 List<Post> posts = this.postRepo.findByCategory(category);
		 postDtoList = posts.stream().map((post)->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		 return postDtoList;
    }

}
