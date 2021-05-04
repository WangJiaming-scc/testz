package com.systop.controller;

import com.systop.entity.Menu;
import com.systop.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Menu> findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        return menuRepository.findAll(index, limit);
    }
}
