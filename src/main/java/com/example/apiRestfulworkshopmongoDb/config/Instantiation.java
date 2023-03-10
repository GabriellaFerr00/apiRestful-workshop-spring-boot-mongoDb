package com.example.apiRestfulworkshopmongoDb.config;

import com.example.apiRestfulworkshopmongoDb.domain.entities.Post;
import com.example.apiRestfulworkshopmongoDb.domain.entities.User;
import com.example.apiRestfulworkshopmongoDb.dto.AuthorDTO;
import com.example.apiRestfulworkshopmongoDb.repositories.PostRepository;
import com.example.apiRestfulworkshopmongoDb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "Maria Brown", "maria@gmail.com");
        User user2 = new User(null, "Alex Green", "alex@gmail.com");
        User user3 = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Post post1 = new Post(null, sdf.parse("21/02/2023"), "Partiu viajarrrr!!!!", "Realizando mais um sonho. Hora de voar", new AuthorDTO(user1));
        Post post2 = new Post(null, sdf.parse("20/03/2023"), "Cheguei recife!!!!", "Já quero voltar novamente, maravilhosa viagem", new AuthorDTO(user1));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
