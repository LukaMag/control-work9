package controlwork9.demo.controllers;

import controlwork9.demo.entity.Task;
import controlwork9.demo.entity.enums.Status;
import controlwork9.demo.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final List<String> statusList = Arrays.asList(Status.CREATED.name(),Status.WORKING.name(),Status.DONE.name(),Status.FAILED.name());
    @GetMapping("/")
        public String tasks(Principal principal, Model model) {
            model.addAttribute("tasks", taskService.findAll());
            model.addAttribute("principal", taskService.getUserByPrincipal(principal));
            return "main";
        }

    @PostMapping("/task")
    public String createTask(Task task, Model model){
        String msg = "Something went wrong" + task.getName() + " " + task.getDateCreated() + " " + task.getUser().getId() + "chekc there";
        if(taskService.create(task) == null) {
            model.addAttribute("errorMessage",msg);
            return "task-create";
        }
            return "redirect:/";

    }
    @GetMapping("/task")
    public String createTask(Model model){
        model.addAttribute("tasks",statusList);
        return "main";
    }
    @GetMapping("/pagination/{page}")
    public String tasksPagination(@PathVariable(name = "page") Integer page,Model model){
        model.addAttribute("page",taskService.findAllPaging(page));
        return "main";
    }
    @GetMapping("/pagination/{page}/{field}")
    public String tasksPagination(@PathVariable(name = "page") Integer page,@PathVariable(name = "field") String field,Model model){
        model.addAttribute("page",taskService.findAllPagingWithSort(page,field));
        return "main";
    }
    @GetMapping("/tasks/{id}")
    public String chooseTask(@PathVariable(name = "id")Long id, Model model,Principal principal){
        model.addAttribute("principal", taskService.getUserByPrincipal(principal));
        model.addAttribute("tasks",taskService.findAllByUser(id));
        return "tasks-choose";
    }
    @GetMapping("/tasks/user/{id}")
    public String editTask(@PathVariable(name = "id")Long id, Model model,Principal principal){
        model.addAttribute("principal", taskService.getUserByPrincipal(principal));
        model.addAttribute("tasks",taskService.findById(id));
        return "task-edit";
    }
    @PostMapping("/task/edit")
    public String editedTask(Task task,Principal principal,Model model){
        taskService.save(task);
        model.addAttribute("tasks",taskService.findAll());
        return "main";
    }
}
