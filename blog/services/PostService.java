package blog.services;

import java.security.PublicKey;

import blog.payloads.PostDto;

public interface PostService {
	
	public PostDto createPost(PostDto postDto);
	
	public PostDto updatePost(PostDto postDto);
	
	public PostDto getPost(PostDto postDto);
	
	public PostDto deletePost(PostDto postDto);
	
	
}
