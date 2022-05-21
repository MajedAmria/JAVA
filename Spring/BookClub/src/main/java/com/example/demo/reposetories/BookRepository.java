package com.example.demo.reposetories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Book;
import com.example.demo.models.User;

@Repository
public interface BookRepository  extends CrudRepository<Book, Long>{
    // this method retrieves all the books from the database
    List<Book> findAll();
   
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
    
    List<Book> findAllByBorrowedBy(User user);
//    List<Book> findByBorrowedByNotContains(User user);

    void deleteById(Long id);
}