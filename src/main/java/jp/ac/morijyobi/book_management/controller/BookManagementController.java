package jp.ac.morijyobi.book_management.controller;

import jp.ac.morijyobi.book_management.bean.entity.Tag;
import jp.ac.morijyobi.book_management.bean.form.BookForm;
import jp.ac.morijyobi.book_management.service.BookService;
import jp.ac.morijyobi.book_management.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/management")
public class BookManagementController {

    private final TagService tagService;
    private final BookService bookService;

    public BookManagementController(TagService tagService, BookService bookService) {
        this.tagService = tagService;
        this.bookService = bookService;
    }
    @GetMapping("/register")
    public String registerBook(Model model) {

        BookForm bookForm = new BookForm();
        model.addAttribute("bookForm", bookForm);

        List<Tag> tagList = tagService.getAllTags();
        model.addAttribute("tagList", tagList);

        return "book/register-book";
    }

    @PostMapping("/register")
    public String registerExe(@Validated BookForm bookForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        if (bindingResult.hasErrors()) {
            List<Tag> tagList = tagService.getAllTags();
            model.addAttribute("tagList", tagList);

            return "book/register-book";
        }

        bookService.registerBook(bookForm);
        redirectAttributes.addFlashAttribute("message", "登録が完了しました。");

        return "redirect:/book/register";
    }
}
