package com.example.myWebApp;

import com.example.myWebApp.user.User;
import com.example.myWebApp.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew(){
        User user=new User();
        user.setEmail("duykhanh.z112233573@gmail.com");
        user.setPassword("270703");
        user.setFirstname("nguyen duy");
        user.setLastname("khanh");
        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);

    }
    @Test
    public void testUpdate(){

        Optional<User> optionalUser = repo.findById(1);

        User user=optionalUser.get();
        user.setPassword("12345");
        user.setLastname("khang");
        repo.save(user);

        User updateUser=repo.findById(1).get();
        Assertions.assertThat(updateUser.getPassword()).isEqualTo("12345");
    }

    @Test
    public void testGet(){
        Optional<User> optionalUser = repo.findById(5);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());

    }
    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for (User user:users){
            System.out.println(user.toString());
        }
    }
    @Test
    public void testDelete(){
        repo.deleteById(5);
        Optional<User> optionUser = repo.findById(5);
        Assertions.assertThat(optionUser).isNotPresent();

    }
}
