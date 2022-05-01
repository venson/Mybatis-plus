package com.venson;

import com.venson.entity.User;
import com.venson.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {


    }

    @Test
    public void findAll(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
