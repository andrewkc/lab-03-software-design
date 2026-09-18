package com.lab03.softwaredesign.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/usuarios")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("usuarios", userService.findAll());
        return "usuarios/lista";
    }

    @GetMapping("/nuevo")
    public String newUser(Model model) {
        User user = new User();
        user.setRol("usuario");
        model.addAttribute("usuario", user);
        return "usuarios/formulario";
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", userService.findById(id));
        return "usuarios/formulario";
    }

    @PostMapping("/guardar")
    public String save(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "usuarios/formulario";
        }
        userService.save(user);
        return "redirect:/usuarios";
    }

    @PostMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/usuarios";
    }
}