package java15.dao;

import java15.entity.Book;

import java.util.List;

public interface BookDao {
    // save
    boolean saveBook(Book book);

    void deleteById(Long id);

    List<Book> findAll();

    // update

    // find by id

    // sort

    // clear

    // group by author full name
}
