package blog.services;

import java.security.PublicKey;
import java.util.List;

import blog.payloads.PostDto;

public interface PostService {
	
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	public PostDto updatePost(PostDto postDto, Integer postId);
	
	public PostDto getPost(PostDto postDto);
	
	public PostDto deletePost(PostDto postDto);
	
	public List<PostDto> getPostsByUser(Integer userId);
	
	public List<PostDto> getPostsByCategory(Integer userId);

	
	
}
