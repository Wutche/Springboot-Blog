package com.aptechph.aptechblog.service.impl;

import com.aptechph.aptechblog.dto.PostDTO;
import com.aptechph.aptechblog.exception.ResourceNotFoundException;
import com.aptechph.aptechblog.model.Post;
import com.aptechph.aptechblog.repository.PostRepository;
import com.aptechph.aptechblog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        //Convert DTO to entity
        Post post = mapToEntity(postDTO);
      Post newPost = postRepository.save(post);

//      Convert entity back to DTO
        PostDTO response = mapToDTO(newPost);

        return response;
    }

    @Override
    public List<PostDTO> getAllPost() {
        return null;
    }

    @Override
    public PostDTO getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDTO(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());

        Post updatedPost = postRepository.save(post);
        return mapToDTO(updatedPost);
    }

    //    Convert DTO to entity
    private Post mapToEntity(PostDTO postDTO){
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());

        Post newPost = postRepository.save(post);
        return post;
    }

    private PostDTO mapToDTO(Post post) {
        PostDTO postResponse = new PostDTO();
        postResponse.setId(post.getId());
        postResponse.setTitle(post.getTitle());
        postResponse.setContent(post.getContent());
        postResponse.setDescription(post.getDescription());
        return postResponse;
    }
}
