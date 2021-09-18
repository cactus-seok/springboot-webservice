package com.cactusseok.book.springwithaws.web;

import com.cactusseok.book.springwithaws.config.auth.LoginUser;
import com.cactusseok.book.springwithaws.config.auth.dto.SessionUser;
import com.cactusseok.book.springwithaws.service.posts.PostsService;
import com.cactusseok.book.springwithaws.web.dto.PostsResponseDto;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}

/*
    index를 반환하므로 View Resolver가 처리
 */
