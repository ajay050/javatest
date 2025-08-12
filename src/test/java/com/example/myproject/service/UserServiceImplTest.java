package com.example.myproject.service;

import com.example.myproject.Models.DepartmentSalary;
import com.example.myproject.Models.UserEntity;
import com.example.myproject.Service.UserServiceImpl;
import com.example.myproject.repository.DepartmentSalaryRepository;
import com.example.myproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private DepartmentSalaryRepository dept;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testGetDataByUserId_exists(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(3L);
        userEntity.setName("Alice");
        DepartmentSalary user = new DepartmentSalary();
        user.setDeptId(3L);
        user.setSalary(100000);
        user.setUser(userEntity);
        when(dept.findByUser(userEntity)).thenReturn(Optional.of(user));
        String result = this.userService.getDataByUserId(3L);
        assertEquals("found", result);
    }
    @Test
    void testGetDataByUserId_notExists() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(3L);
        when(dept.findByUser(Mockito.argThat(u -> u.getUserId()==3L)))
                .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.getDataByUserId(3L);
        });

        assertEquals("User not found with id: 3", exception.getMessage());
    }
}
