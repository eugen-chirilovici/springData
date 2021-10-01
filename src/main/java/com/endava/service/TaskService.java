package com.endava.service;

import com.endava.entity.Task;
import com.endava.entity.User;
import com.endava.entity.enums.Status;
import com.endava.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> selectTasksByNameStartWith(String value) {
        return taskRepository.selectTasksByNameStartWith(value + "%");
    }

    public List<Task> getAllByNameStartingWith(String value){
        return taskRepository.getAllByNameStartingWith(value);
    }

    public Task getTaskByNameStartingWithAndAssignee(String name, User assignee){
        return taskRepository.getTaskByNameStartingWithAndAssignee(name, assignee);
    }

    public List<Task> getAllByNameAndStatus(String name, Status status) {
        return taskRepository.getAllByNameAndStatus(name, status);
    }

    public List<Task> getAllByName(String name, Pageable pageable){
        return taskRepository.getAllByName(name, pageable).toList();
    }
}
