package com.example.myWebApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public User get(Integer id) throws UserNotFoundExeption {
        Optional<User> result = repo.findById(id);
        if(result.isPresent())
            return  result.get();
        throw new UserNotFoundExeption("Cound not finf any user with ID"+id);
    }

    public void delete(Integer id) throws UserNotFoundExeption {
        Long count=repo.countById(id);
        if(count==0 || count==null)
            throw new UserNotFoundExeption("Cound not finf any user with ID"+id);
        repo.deleteById(id);
    }
}
