package com.tugasdocker6.deploy.controller;

import com.tugasdocker6.deploy.model.User;
import com.tugasdocker6.deploy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    // Kredensial sesuai instruksi tugas
    private final String USERNAME = "admin";
    private final String PASSWORD = "20230140050";

    private final UserService userService;

    // Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // == LOGIN ==
    // Halaman login sebagai entry point utama
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    // Proses autentikasi
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Username atau Password salah!");
            return "login";
        }
    }

    // == HOME ==
    // Menampilkan halaman Home dan tabel data
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("datalist", userService.getAllUsers());
        return "home";
    }

    // == CREATE ==
    // Menampilkan form input mahasiswa
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    // Menyimpan data ke list temporary dan kembali ke home
    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/home";
    }

    // Fitur logout untuk kembali ke halaman login
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}