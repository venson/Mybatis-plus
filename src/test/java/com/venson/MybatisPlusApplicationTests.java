package com.venson;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.venson.entity.User;
import com.venson.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUser() {
//        User user = new User(203L, "cury",12, "cury.junier@qq.com",null,null,null,null);
        User user = new User();
        user.setId(203L);
        user.setName("curry");
        user.setAge(12);
        user.setEmail("curry@qq.com");
        userMapper.insert(user);
        log.info("add user: \n" + user);


    }

    @Test
    public void findAll(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(2L);
        user.setName("James lower");
        user.setAge(8);

        log.info("start update user");
        userMapper.updateById(user);
        log.info("finish update user");

        //userMapper.update()

    }
        @Test
        public void testOptimisticLocker(){
            User user1 = userMapper.selectById(203L);
            user1.setAge(666);
            user1.setUpdateTime(null);
            userMapper.updateById(user1);


        }


        @Test
        public void testPage(){
            Page<User> userPage = new Page<>(2,3);
            Page<User> userPage1 = userMapper.selectPage(userPage, null);
            System.out.println(userPage.getCurrent());
            System.out.println("================================");
            userPage.getRecords().forEach(System.out::println);
            System.out.println("============================");
            long pages = userPage.getPages();
            System.out.println(pages);
            System.out.println("userPage.getPages()" + userPage1.getPages());
            System.out.println("userPage.getSize()" + userPage.getSize());
            System.out.println(userPage.hasNext());
            System.out.println(userPage.hasPrevious());
        }

        @Test
        public void testDelete(){
//            userMapper.deleteBatchIds(Arrays.asList(1,2));
            userMapper.deleteById(201L);
        }
}
