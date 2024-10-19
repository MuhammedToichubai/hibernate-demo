package java15.service;

import java15.entity.Book;

import java.util.List;

public interface BookService {
    String saveBook(Book book);

    String deleteById(Long id);

    List<Book> findAll();

}
