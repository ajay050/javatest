package com.example.myproject.Service;

import com.example.myproject.Models.DepartmentSalary;
import com.example.myproject.Models.UserEntity;
import com.example.myproject.repository.DepartmentSalaryRepository;
import com.example.myproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl {

    private final DepartmentSalaryRepository rp;

    @Autowired
    public UserServiceImpl(DepartmentSalaryRepository rp) {
        this.rp = rp;
    }
    public String getDataByUserId(long userId){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        DepartmentSalary user = rp.findByUser(userEntity)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        if(user==null) {
            return "not found";
        } else{
            return "found";
        }
    }

}
