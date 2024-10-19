package java15.service;

import java15.dao.BookDao;
import java15.dao.BookDaoImpl;
import java15.entity.Book;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    public String saveBook(Book book) {
        return bookDao.saveBook(book) ? "Saved" : "Failed";
    }

    @Override
    public String deleteById(Long id) {
        String result = "Deleted";
        try {
            bookDao.deleteById(id);
        } catch (Exception e) {
            result = "Not Deleted";
        }
        return result;
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

}
