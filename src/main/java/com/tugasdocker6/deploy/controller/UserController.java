package com.tugasdocker6.deploy.controller;

import com.tugasdocker6.deploy.model.User;
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

    // List untuk menampung data mahasiswa secara temporary
    private static List<User> userList = new ArrayList<>();

    // Halaman login sebagai entry point utama [cite: 56, 71]
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    // Proses autentikasi [cite: 70, 73]
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

    // Menampilkan halaman Home dan tabel data [cite: 55, 74, 78]
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("users", userList);
        return "home";
    }

    // Menampilkan form input mahasiswa [cite: 54, 85]
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    // Menyimpan data ke list temporary dan kembali ke home [cite: 92, 96]
    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userList.add(user);
        return "redirect:/home";
    }

    // Fitur logout untuk kembali ke halaman login
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}