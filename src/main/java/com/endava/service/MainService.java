package com.endava.service;

import com.endava.containers.PageRequestContainer;
import com.endava.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.endava.utils.PageUtils.getSortField;

@Service
@RequiredArgsConstructor
public class MainService {

    private final InsertEntitiesService insertEntitiesService;

    private final UserService userService;

    @PostConstruct
    void letsGo() {
        insertEntitiesService.insertEntities();

        List<User> usersPage = userService.getUsersPage(new PageRequestContainer(0, 2, Sort.by("email")));

        List<User> usersPage2 = userService.getUsersPage(new PageRequestContainer(1, 2,
                                                                                  getSortField(User.class)));


    }

}
