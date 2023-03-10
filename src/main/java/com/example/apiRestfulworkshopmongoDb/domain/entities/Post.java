package com.example.apiRestfulworkshopmongoDb.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "post")
public class Post {
        @Id
        private String id;
        private Date date;
        private String title;
        private String body;
        private User author;

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Post post = (Post) o;
                return id.equals(post.id);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id);
        }
}
