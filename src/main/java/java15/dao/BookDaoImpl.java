package java15.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java15.config.DatabaseConnection;
import java15.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao, AutoCloseable {
    private final EntityManager entityManager = DatabaseConnection.getEntityManagerFactory().createEntityManager();

    @Override
    public boolean saveBook(Book book) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
//            Book book = entityManager.find(Book.class, id);

            Book findBook = entityManager
                    .createQuery("select b from Book b where b.id = :id ", Book.class)
                    .setParameter("id", id).getSingleResult();

            entityManager.remove(findBook);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }


    // SQL HQL
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Book> selectBFromBookB = entityManager.createQuery("select b from Book b", Book.class);
            books = selectBFromBookB.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return books;
    }


    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
