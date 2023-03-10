package com.example.apiRestfulworkshopmongoDb.dto;

import com.example.apiRestfulworkshopmongoDb.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private String id;
    private String name;

    public AuthorDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
    }
}
