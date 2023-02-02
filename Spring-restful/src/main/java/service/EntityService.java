package service;

import configuration.JPAConfig;
import entity.BookEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import repository.BookRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EntityService {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");

    public static List<BookEntity> findAll(){
        return bookRepository.findAll();
    }

    public static List<BookEntity> findByNameContainingOrAuthorContaining(String name, String author){
        List<BookEntity> bookEntityList = bookRepository.findByNameContainingOrAuthorContaining(name, author);
        return bookEntityList;
    }

    public static BookEntity updateBook(BookEntity newBookData){
        boolean isFound = false;
        BookEntity foundBook = null;
        List<BookEntity> bookEntityList = findAll();
        for (BookEntity bookEntity : bookEntityList){
            if (newBookData.getId() == bookEntity.getId()){
                isFound = true;
                break;
            }
        }
        if (!isFound)
            return null;
        bookRepository.save(newBookData);
        return newBookData;
    }

    public static boolean deleteBook(int id){
        boolean isFound = false;
        BookEntity foundBook = null;
        List<BookEntity> bookEntityList = findAll();
        for (BookEntity bookEntity : bookEntityList){
            if (id == bookEntity.getId()){
                isFound = true;
                foundBook = bookEntity;
                break;
            }
        }
        if (!isFound)
            return false;
        bookRepository.deleteById(id);
        return true;
    }
}
