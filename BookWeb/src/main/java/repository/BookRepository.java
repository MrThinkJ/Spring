package repository;

import entity.BookEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity, Integer> {
    List<BookEntity> findAll();
    List<BookEntity> findById(int id);
    List<BookEntity> findByNameContainingOrAuthorContaining(String name, String author);
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "ALTER TABLE book AUTO_INCREMENT = 1;", nativeQuery = true)
    void removeRedundancyBookId();
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "ALTER TABLE bookdetails AUTO_INCREMENT = 1;", nativeQuery = true)
    void removeRedundancyBookDetailsId();
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "delete from bookdetails where id = ?1", nativeQuery = true)
    void removeBookDetailById(int id);
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "insert into book(author, name, categoryId) value(?1,?2,?3)", nativeQuery = true)
    void addBook(String author, String name, int categoryId);

    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "insert into bookdetails(isbn, numberOfPage, price, publishDate) value(?1,?2,?3,?4)", nativeQuery = true)
    void addBookDetail(String isbn, int numberOfPage, int price, LocalDate publishDate);
}
