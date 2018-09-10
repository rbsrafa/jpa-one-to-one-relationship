package com.example.jpaonetoonerelationship;

import com.example.jpaonetoonerelationship.models.FreePage;
import com.example.jpaonetoonerelationship.models.User;
import com.example.jpaonetoonerelationship.repositories.FreePageRepository;
import com.example.jpaonetoonerelationship.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaOneToOneRelationshipApplication implements CommandLineRunner{
    
    @Autowired
    private UserRepository users;
    
    @Autowired
    private FreePageRepository freePages;

    public static void main(String[] args) {
        SpringApplication.run(JpaOneToOneRelationshipApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        this.freePages.deleteAllInBatch();
        this.users.deleteAllInBatch();
        
        User user1 = new User("John", "Smith", "johnsmith@email.com", "john123");
        User user2 = new User("Linda", "Smith", "lindasmith@email.com", "linda123");
       
        FreePage freePage1 = new FreePage("john-project", "https://www.johnsite.com");
        FreePage freePage2 = new FreePage("linda-project", "https://www.lindasite.com");
        
        user1.setFreePage(freePage1);
        user2.setFreePage(freePage2);
        
        freePage1.setUser(user1);
        freePage2.setUser(user2);
        
        users.save(user1);
        users.save(user2);
 
    }
}
