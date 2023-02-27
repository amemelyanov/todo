package ru.job4j.todo.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.todo.model.Category;
import ru.job4j.todo.model.Task;
import ru.job4j.todo.model.User;
import ru.job4j.todo.service.CategoryService;
import ru.job4j.todo.service.TaskService;
import ru.job4j.todo.util.UserUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер задач
 * @author Alexander Emelyanov
 * @version 1.0
 */
@Slf4j
@AllArgsConstructor
@Controller
public class TaskController {

    /**
     * Объект для доступа к методам TaskService
     */
    private final TaskService taskService;

    /**
     * Объект для доступа к методам CategoryService
     */
    private final CategoryService categoryService;

    @GetMapping("/tasks")
    public String getTasks(Model model, HttpServletRequest request) {
        model.addAttribute("user", UserUtil.getSessionUser(request));
        model.addAttribute("tasks", taskService.findAllTasks());
        return "task/tasks";
    }

    @GetMapping("/newTasks")
    public String getNewTasks(Model model, HttpServletRequest request) {
        model.addAttribute("user", UserUtil.getSessionUser(request));
        model.addAttribute("tasks", taskService.findNewTasks());
        return "task/tasks";
    }

    @GetMapping("/doneTasks")
    public String getDoneTasks(Model model, HttpServletRequest request) {
        model.addAttribute("user", UserUtil.getSessionUser(request));
        model.addAttribute("tasks", taskService.findDoneTasks());
        return "task/tasks";
    }

    @GetMapping("/addTask")
    public String addTask(Model model, HttpServletRequest request) {
        User user = UserUtil.getSessionUser(request);
        model.addAttribute("user", user);
        Task task = new Task();
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("task", task);
        return "task/addTask";
    }

    @PostMapping("/addOrUpdateTask")
    public String saveTask(@ModelAttribute Task task,
                           @RequestParam(value = "categoryIds", required = false) List<Integer> categoryIds,
                           HttpServletRequest request) {
        User user = UserUtil.getSessionUser(request);
        task.setUser(user);
        List<Category> categories = categoryService.findCategoriesByIds(categoryIds);
        task.setCategories(categories);
        taskService.addOrUpdateTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/taskDetails{taskId}")
    public String getTaskDetails(@RequestParam(value = "taskId") int taskId,
            Model model, HttpServletRequest request) {
        model.addAttribute("user", UserUtil.getSessionUser(request));
        model.addAttribute("task", taskService.findTaskById(taskId));
        return "task/taskDetails";
    }

    @GetMapping("/taskDone{taskId}")
    public String taskDone(@RequestParam(value = "taskId") int taskId,
            Model model, HttpServletRequest request) {
        Task task = taskService.taskDone(taskId);
        model.addAttribute("user", UserUtil.getSessionUser(request));
        model.addAttribute("task", task);
        return "task/taskDetails";
    }

    @GetMapping("/editTask{taskId}")
    public String editTask(@RequestParam(value = "taskId") int taskId,
            Model model, HttpServletRequest request) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("user", UserUtil.getSessionUser(request));
        model.addAttribute("task", taskService.findTaskById(taskId));
        return "task/editTask";
    }

    @GetMapping("/deleteTask{taskId}")
    public String deleteTask(@RequestParam(value = "taskId") int taskId,
            HttpServletRequest request) {
        taskService.deleteTaskById(taskId);
        return "redirect:/tasks";
    }
}