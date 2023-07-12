package com.aptechph.aptechblog.service;

import com.aptechph.aptechblog.dto.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);

    List<PostDTO> getAllPost();
}
