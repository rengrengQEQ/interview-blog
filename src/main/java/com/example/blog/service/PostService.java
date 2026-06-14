package com.example.blog.service;

import com.example.blog.entity.Post;
import com.example.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // 获取所有文章
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    // 根据ID查找文章
    public Post findById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElse(null);
    }

    // 创建新文章
    public Post createPost(Post post) {
        post.setCreateTime(LocalDateTime.now());
        post.setUpdateTime(LocalDateTime.now());
        return postRepository.save(post);
    }

    // 更新文章
    public Post updatePost(Long id, Post updatedPost) {
        Post existingPost = findById(id);
        if (existingPost != null) {
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setSummary(updatedPost.getSummary());
            existingPost.setContent(updatedPost.getContent());
            existingPost.setUpdateTime(LocalDateTime.now());
            return postRepository.save(existingPost);
        }
        return null;
    }

    // 删除文章
    public boolean deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }
}