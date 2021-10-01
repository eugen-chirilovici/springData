package com.endava.utils;

import com.endava.entity.Discipline;
import com.endava.entity.Role;
import com.endava.entity.Task;
import com.endava.entity.User;
import com.endava.entity.enums.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Factories {

    public static List<Role> roleFactory() {
        return new ArrayList<Role>(){{
            add(new Role("Engineer"));
            add(new Role("Project Leader"));
            add(new Role("Manager"));
        }};
    }

    public static List<Discipline> disciplineFactory() {
        return new ArrayList<Discipline>(){{
            add(Discipline.builder()
                          .name("AM")
                          .members(new HashSet<>())
                          .build());

            add(Discipline.builder()
                          .name("Testing")
                          .members(new HashSet<>())
                          .build());

            add(Discipline.builder()
                          .name("Dev")
                          .members(new HashSet<>())
                          .build());

        }};
    }

    public static List<Task> tasksFactory() {

        return new ArrayList<Task>(){{
            add(Task.builder()
                    .name("Create Header")
                    .description("Create header of HHTP request")
                    .startDate(LocalDate.of(2020,  4, 10))
                    .endDate(LocalDate.of(2020, 5, 10))
                    .status(Status.TODO)
                    .build());

            add(Task.builder()
                    .name("Create Header")
                    .description("Create body of the site")
                    .startDate(LocalDate.of(2020, 4, 5))
                    .endDate(LocalDate.of(2020, 6, 10))
                    .status(Status.PROGRESS)
                    .build());

            add(Task.builder()
                    .name("Delete button")
                    .description("Create delete button for admins")
                    .startDate(LocalDate.of(2020, 4, 12))
                    .endDate(LocalDate.of(2020, 5, 14))
                    .status(Status.REVIEW)
                    .build());

            add(Task.builder()
                    .name("Do something")
                    .description("Create something, stop being lazy")
                    .startDate(LocalDate.of(2020, 4, 1))
                    .endDate(LocalDate.of(2020, 5, 17))
                    .status(Status.DONE)
                    .build());

        }};
    }

    public static List<User> usersFactory() {
        return new ArrayList<User>(){{
            add(User.builder()
                    .fName("Rustam")
                    .lName("Saghivaliev")
                    .email("Rustam.Saghivaliev@endava.com")
                    .userName("rsaghivaliev")
                    .createdAt(LocalDate.of(2020, 3, 10))
                    .enable(true)
                    .roles(new HashSet<>())
                    .build());

            add(User.builder()
                    .fName("Eugen")
                    .lName("Chirilovici")
                    .email("Eugen.Chirilovici@endava.com")
                    .userName("echirilovici")
                    .createdAt(LocalDate.of(2020, 4, 10))
                    .enable(true)
                    .roles(new HashSet<>())
                    .build());

            add(User.builder()
                    .fName("Vasile")
                    .lName("Dmitruc")
                    .email("Vasile.Dmitruc@endava.com")
                    .userName("vdmitruc")
                    .createdAt(LocalDate.of(2020, 5, 10))
                    .enable(true)
                    .roles(new HashSet<>())
                    .build());

            add(User.builder()
                    .fName("Victor")
                    .lName("Cumpana")
                    .email("Victor.Cumpana@endava.com")
                    .userName("vcumpana")
                    .createdAt(LocalDate.of(2020, 7, 10))
                    .enable(true)
                    .roles(new HashSet<>())
                    .build());

        }};
    }

}
