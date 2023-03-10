package com.example.apiRestfulworkshopmongoDb.services;

import com.example.apiRestfulworkshopmongoDb.domain.entities.User;
import com.example.apiRestfulworkshopmongoDb.dto.UserDTO;
import com.example.apiRestfulworkshopmongoDb.exception.ObjectNotFoundException;
import com.example.apiRestfulworkshopmongoDb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User user){
       return  userRepository.insert(user);
    }
    //esse metodo fere a responsabilidade unica, porem, dedpendendo da situacao para instanciar um user, posso querer acessar
    //o banco de dados e quem tem essa injecao de dependencia e o userService

    public void delete(String id){
        this.findById(id);
        userRepository.deleteById(id);
    }

    public User update(User user){
        User user2 = this.findById(user.getId());
        updateData(user2, user);

        return userRepository.save(user2);
    }

    private void updateData(User user2, User user) {
        user2.setName(user.getName());
    }

    public User fromDTO(UserDTO dto){
        return new User(dto.getId(), dto.getName());
    }

}
