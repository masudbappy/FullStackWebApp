package com.masudbappy.fullstackwebapp;

import com.masudbappy.fullstackwebapp.entities.Task;
import com.masudbappy.fullstackwebapp.entities.User;
import com.masudbappy.fullstackwebapp.services.TaskService;
import com.masudbappy.fullstackwebapp.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FullstackwebappApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @Before
    public void initDab() {
        {
            User newUser = new User("testUser@gmail.com", "testUser", "123455");
            userService.createUser(newUser);
        }
        {
            User newUser = new User("testAdmin@gmail.com", "testAdmin", "123455");
            userService.createUser(newUser);
        }

        Task userTask = new Task("03/01/2019", "12.00", "01:33", "You need to work today");
        User user = userService.findOne("testUser@gmail.com");
        taskService.addTask(userTask, user);
    }

    @Test
    public void testUser() {
        User user = userService.findOne("testUser@gmail.com");
        Assert.assertNotNull(user);
        User admin = userService.findOne("testAdmin@gmail.com");
        Assert.assertEquals(admin.getEmail(),"testAdmin@gmail.com");
    }
    @Test
    public void testTask(){
        User user = userService.findOne("testUser@gmail.com");
        List<Task> tasks = taskService.findUserTask(user);
        Assert.assertNotNull(tasks);
    }

}
