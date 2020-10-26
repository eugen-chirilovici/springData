package com.endava.service;

import com.endava.entity.Discipline;
import com.endava.entity.Role;
import com.endava.entity.Task;
import com.endava.entity.User;
import com.endava.repository.DisciplineRepository;
import com.endava.repository.RoleRepository;
import com.endava.repository.TaskRepository;
import com.endava.repository.UserRepository;
import com.endava.utils.Factories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class InsertEntitiesService {

    private final DisciplineRepository disciplineRepository;

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public void insertEntities() {
        saveRolesAndUsers();
        saveDisciplinesAndTask();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void saveRolesAndUsers(){
        List<Role> roles = Factories.roleFactory();
        roleRepository.saveAll(roles);

        List<User> users = Factories.usersFactory();
        userRepository.saveAll(users);

        users.forEach(user ->
            user.getRoles().add(roles.get(randomIndexOfObjectFromList(roles.size())))
        );

        userRepository.saveAll(users);

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void saveDisciplinesAndTask(){
        List<User> users = userRepository.findAll();

        List<Discipline> disciplines = Factories.disciplineFactory();
        disciplineRepository.saveAll(disciplines);

        Discipline discipline1 = disciplines.get(0);
        discipline1.setHod(users.get(0));
        Set<User> members1 = discipline1.getMembers();
        members1.add(users.get(0));
        members1.add(users.get(3));

        Discipline discipline2 = disciplines.get(1);
        discipline2.setHod(users.get(1));
        discipline2.getMembers().add(users.get(1));

        Discipline discipline3 = disciplines.get(2);
        discipline3.setHod(users.get(2));
        discipline3.getMembers().add(users.get(2));

        disciplineRepository.saveAll(disciplines);

        List<Task> tasks = Factories.tasksFactory();
        taskRepository.saveAll(tasks);

        Task task1 = tasks.get(0);
        task1.setAssignee(users.get(0));

        Task task2 = tasks.get(1);
        task2.setAssignee(users.get(1));

        Task task3 = tasks.get(2);
        task3.setAssignee(users.get(2));

        Task task4 = tasks.get(3);
        task4.setAssignee(users.get(3));

        taskRepository.saveAll(tasks);

    }

    private int randomIndexOfObjectFromList(int listSize){
        int min = 0;
        return (int)(Math.random() * (listSize - min) + min);
    }

}

