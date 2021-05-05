package com.systop.controller;

import com.systop.entity.Menu;
import com.systop.entity.MenuVo;
import com.systop.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVo findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        return menuFeign.findAll(index, limit);
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @GetMapping("/delById/{id}")
    public String delete(@PathVariable("id") long id){
        menuFeign.delete(id);
        return "redirect:/menu/redirect/index";
    }

    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("list",menuFeign.findTypes());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "redirect:/menu/redirect/index";
    }
}
