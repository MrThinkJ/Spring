package service;

import configuration.JPAConfig;
import entity.BookDetailsEntity;
import entity.BookEntity;
import entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import repository.BookRepository;
import repository.CategoryRepository;

import java.util.List;

@Service
public class EntityService {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
    @Autowired
    static CategoryRepository categoryRepository = (CategoryRepository) context.getBean("categoryRepository");

    public static List<BookEntity> findAllBook(){
        List<BookEntity> bookEntityList = bookRepository.findAll();
        return bookEntityList;
    }
    public static List<BookEntity> findById(int id){
        List<BookEntity> bookEntityList = bookRepository.findById(id);
        return bookEntityList;
    }

    public static List<BookEntity> findByNameContainingOrAuthorContaining(String name, String author){
        List<BookEntity> bookEntityList = bookRepository.findByNameContainingOrAuthorContaining(name, author);
        return bookEntityList;
    }

    public static void deleteBookById(int id){
        bookRepository.removeBookDetailById(id);
        bookRepository.deleteById(id);
        bookRepository.removeRedundancyBookId();;
        bookRepository.removeRedundancyBookDetailsId();
    }

    public static void updateBook(BookEntity book){
        bookRepository.save(book);
    }

    public static void updateCategory(CategoryEntity category){
        categoryRepository.save(category);
    }

    public static List<CategoryEntity> findAllCategory(){
        List<CategoryEntity> categoryEntityList = (List<CategoryEntity>) categoryRepository.findAll();
        return categoryEntityList;
    }

    public static void addBook(BookEntity book, BookDetailsEntity bookDetails){
        bookRepository.addBook(book.getAuthor(), book.getName(), book.getCategory().getId());
        bookRepository.addBookDetail(bookDetails.getIsbn(), bookDetails.getNumberOfPage(), bookDetails.getPrice(), bookDetails.getPublishDate());
    }
}
