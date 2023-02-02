package controller;

import configuration.JPAConfig;
import entity.BookEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;
import repository.BookRepository;
import service.EntityService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");

    @GetMapping()
    public List<BookEntity> getAllBook() {
        List<BookEntity> bookEntityList = EntityService.findAll();
        return bookEntityList;
    }

    @PostMapping()
    public Object addNewBook(@RequestBody BookEntity book) {
        BookEntity result = bookRepository.save(book);
        return result;
    }

    @PutMapping()
    public Object updateBook(@RequestBody BookEntity newBookData) {
        BookEntity result = EntityService.updateBook(newBookData);
        if (result == null) {
            Map<String, String> error = new HashMap<String, String>() {{
                put("error", newBookData.getId() + " does not exist");
            }};
            return error;
        }
        return result;
    }

    @DeleteMapping(path = "/delete/{id}")
    public Object deleteBook(@PathVariable(name = "id") int id) {
        Boolean result = EntityService.deleteBook(id);
        if (!result) {
            Map<String, String> error = new HashMap<String, String>() {{
                put("error", id + " does not exist");
            }};
            return error;
        }
        Map<String, String> success = new HashMap<String, String>() {{
            put("Book have ", id + " has been deleted successfully");
        }};
        return success;
    }

    @GetMapping(path = "/search")
    public Object searchBook(@RequestParam String nameOrAuthor){
        List<BookEntity> bookEntityList = EntityService.findByNameContainingOrAuthorContaining(nameOrAuthor, nameOrAuthor);
        if (bookEntityList.size() == 0){
            Map<String, String> error = new HashMap<>(){{
                put("notFound", "Not found book have name or author "+nameOrAuthor);
            }};
            return error;
        }
        return bookEntityList;
    }
}
