package com.systop.controller;

import com.systop.entity.MenuVo;
import com.systop.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "menu的当前端口为："+this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVo findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        return new MenuVo(0,"",menuRepository.count(),menuRepository.findAll(index, limit));
    }

    @DeleteMapping("/delById/{id}")
    public void delById(@PathVariable("id") long id){
        menuRepository.deleteById(id);
    }
}
