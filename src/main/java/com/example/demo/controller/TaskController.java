package com.example.demo.controller;

import java.security.Principal;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import com.example.demo.model.Tasks;
import com.example.demo.model.User;
import com.example.demo.service.TasksService;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/Tasks")
public class TaskController
{
	@Autowired
	TasksService ser;
	
	@GetMapping("/allTasks")
	public List<Tasks> getAll()
	{
		return ser.getAllTasks();
	}
	
	
	@GetMapping("/{id}")
	public Tasks  getTaskById(@PathVariable("id") Long id)
	{
		return ser.getTaskById(id);
	}
	
	
	@PostMapping("/addTask")
	public Tasks addTask(@RequestBody Tasks task)
	{
		return ser.addTask(task);
	}
	
	
	@PutMapping("/update")
	public Tasks updateTask(@RequestBody Tasks task)
	{
		return ser.updateTask(task);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteTask(@PathVariable("id") Long id)
	{
		ser.deleteTask(id);
	}
	
	@RequestMapping("/login")
	public boolean login(@RequestBody User user) {
		return user.getUserName().equals("user") && user.getPassword().equals("password");
	}

	
}
