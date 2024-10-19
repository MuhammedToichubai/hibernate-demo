package java15;

import java15.entity.Book;
import java15.service.BookService;
import java15.service.BookServiceImpl;

import java.math.BigDecimal;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();

//        System.out.println(bookService.saveBook(
//                new Book(
//                        "Jashoonun Formulasy",
//                        "Chubak ajy Jalilov",
//                        BigDecimal.valueOf(1200)
//                )
//        ));

//        System.out.println(bookService.deleteById(1L));

        List<Book> bookList = bookService.findAll();
        bookList.forEach(System.out::println);


    }
}
