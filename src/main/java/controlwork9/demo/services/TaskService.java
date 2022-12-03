package controlwork9.demo.services;

import controlwork9.demo.entity.Task;
import controlwork9.demo.entity.User;
import controlwork9.demo.repositories.TaskRepository;
import controlwork9.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public Page<Task> findPageAndSorted(String status,Pageable pageable){
        status = status.toUpperCase(Locale.ROOT);
        return taskRepository.findAll(pageable);
    }
    public Page<Task> findAllPaging(Integer page){
        return taskRepository.findAll(PageRequest.of(page,5));
    }
    public List<Task> findAll(){
        return taskRepository.findAll();
    }
    public Page<Task> findAllPagingWithSort(Integer page,String field){
        return taskRepository.findAll(PageRequest.of(page,5).withSort(Sort.by(field)));
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public User getUserByPrincipal(Principal principal) {
        if(principal == null) return new User();
        return userRepository.findUserByEmail(principal.getName());
    }
    public List<Task> findAllByUser(Long id){
        return taskRepository.findAllByUserId(id);
    }

    public Task findById(Long id){
        return taskRepository.getById(id);
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }
}
