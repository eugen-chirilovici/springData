package com.endava.repository;

import com.endava.entity.Task;
import com.endava.entity.User;
import com.endava.entity.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.name LIKE (:v)")
    List<Task> selectTasksByNameStartWith(@Param("v") String value);

    @Query(nativeQuery = true, value = "SELECT * FROM task t WHERE t.name LIKE (:v)")
    List<Task> selectTasksByNameStartWithNQ(@Param("v") String value);

    List<Task> getAllByNameStartingWith(String value);

    Task getTaskByNameStartingWithAndAssignee(String name, User assignee);

    List<Task> getAllByNameAndStatus(String name, Status status);

    Page<Task> getAllByName(String name, Pageable pageable);

}
