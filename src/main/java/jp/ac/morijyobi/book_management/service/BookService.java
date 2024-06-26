package jp.ac.morijyobi.book_management.service;

import jp.ac.morijyobi.book_management.bean.dto.LoanedBookDTO;
import jp.ac.morijyobi.book_management.bean.entity.Book;
import jp.ac.morijyobi.book_management.bean.form.BookForm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface BookService {

    void registerBook(BookForm bookForm);

    List<Book> getBooksByKeyword(String keyword);

    Book getBookById(int bookId);
    boolean registerBookLoan(int bookId, String username);

    boolean returnBookLoans(int bookId, UserDetails userDetails);

    List<LoanedBookDTO> getLoanedBooksByUser(UserDetails userDetails);

}
