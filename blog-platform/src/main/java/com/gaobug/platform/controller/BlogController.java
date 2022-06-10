package com.gaobug.platform.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gaobug.base.annotation.BindUser;
import com.gaobug.base.context.JwtContext;
import com.gaobug.response.ResponseWrapped;
import com.gaobug.database.wrapped.PageWrapped;
import com.gaobug.platform.domain.Blog;
import com.gaobug.platform.dto.BlogAddDTO;
import com.gaobug.platform.dto.BlogUpdateDTO;
import com.gaobug.platform.service.BlogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 博客首页相关接口
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    /**
     * 获取博客详情
     */
    @GetMapping("/info/{id}")
    public ResponseWrapped<Object> getBlogInfo(@PathVariable String id) {
        return ResponseWrapped.success(blogService.getById(id));
    }

    /**
     * 获取博客列表
     */
    @BindUser
    @GetMapping("/page")
    public ResponseWrapped<Object> getBlogPage(Page<Blog> page, Blog blog) {
        blog.setAuthor(JwtContext.getUserId());
        return ResponseWrapped.success(new PageWrapped(blogService.getBlogPageByUser(page, blog)));
    }

    /**
     * 添加博客
     */
    @PostMapping("/add")
    public ResponseWrapped<Object> addBlog(@RequestBody BlogAddDTO blog) {
        blogService.addBlog(blog);
        return ResponseWrapped.success();
    }

    /**
     * 更新博客
     */
    @PostMapping("/update")
    public ResponseWrapped<Object> updateBlog(@RequestBody BlogUpdateDTO blog) {
        blogService.updateBlog(blog);
        return ResponseWrapped.success();
    }

    /**
     * 发布博客
     */
    @PostMapping("/publish/{id}")
    public ResponseWrapped<Object> publishBlog(@PathVariable String id) {
        blogService.publishBlog(id);
        return ResponseWrapped.success();
    }
}