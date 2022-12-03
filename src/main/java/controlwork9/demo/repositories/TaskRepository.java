package controlwork9.demo.repositories;

import controlwork9.demo.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    Page<Task> findAll(Pageable pageable);

    List<Task> findAllByUserId(Long id);

}
