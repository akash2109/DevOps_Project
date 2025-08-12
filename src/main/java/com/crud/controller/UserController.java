package com.crud.controller;

import com.crud.entity.User;
import com.crud.service.SessionManager;
import com.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String listUsers(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || !SessionManager.isValidSession(session)) {
            return "redirect:/login";
        }
        model.addAttribute("users", userService.list());
        return "list-users";
    }

    @GetMapping("/add")
    public String addUserForm(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || !SessionManager.isValidSession(session)) {
            return "redirect:/login";
        }
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || !SessionManager.isValidSession(session)) {
            return "redirect:/login";
        }
        userService.save(user);
        return "redirect:./";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || !SessionManager.isValidSession(session)) {
            return "redirect:/login";
        }
        model.addAttribute("user", userService.get(id));
        return "edit-user";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || !SessionManager.isValidSession(session)) {
            return "redirect:/login";
        }
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || !SessionManager.isValidSession(session)) {
            return "redirect:/login";
        }
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/home")
    public String showListUsers(Model model,  HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || !SessionManager.isValidSession(session)) {
            return "redirect:/login";
        }
        model.addAttribute("users", userService.list());
        return "list-users";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        User user = userService.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            SessionManager.addSession(username, session);
            return "redirect:/home";
        } else {
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String username = (String) session.getAttribute("username");
            SessionManager.removeSession(username);
            session.invalidate();
        }
        return "redirect:/login";
    }
}
