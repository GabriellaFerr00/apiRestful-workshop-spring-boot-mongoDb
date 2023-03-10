package com.example.apiRestfulworkshopmongoDb.dto;

import com.example.apiRestfulworkshopmongoDb.domain.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String name;

    public UserDTO(User user){
        id = user.getId();
        name = user.getName();
    }
}
