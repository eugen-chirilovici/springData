package com.endava.service;

import com.endava.containers.PageRequestContainer;
import com.endava.entity.User;
import com.endava.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsersPage(PageRequestContainer pageContainer){
        Page<User> userPage = userRepository.findAll(PageRequest.of(pageContainer.getPageNumber(),
                                                                    pageContainer.getPageSize(),
                                                                    pageContainer.getSort()));
        return userPage.toList();
    }
}
