package com.systop.controller;

import com.systop.entity.Menu;
import com.systop.entity.MenuVo;
import com.systop.entity.Type;
import com.systop.repository.MenuRepository;
import com.systop.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private TypeRepository typeRepository;

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

    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        return typeRepository.findTypes();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuRepository.save(menu);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuRepository.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuRepository.update(menu);
    }
}
