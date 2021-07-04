package com.nghinv.beddingsellintroduce.controller;

import com.nghinv.beddingsellintroduce.common.clientFrom.BooksCreationDto;
import com.nghinv.beddingsellintroduce.common.dto.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/books")
public class BookController {


    static ArrayList<Book> books = new ArrayList<>();
    static {
        books.add(new Book(1,"title 1", "author 1" ));
        books.add(new Book(2,"title 2", "author 2" ));
        books.add(new Book(3,"title 3", "author 3" ));
    }

    @GetMapping("/index")
    public String index() {

        return "/books/index";
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        if (model.getAttribute("books") != null) {
            model.addAttribute("books", model.getAttribute("books"));
        }
        else {
            model.addAttribute("books", books);
        }
        return "/books/allBooks";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        BooksCreationDto booksForm = new BooksCreationDto();

        for (int i = 1; i <= 3; i++) {
            booksForm.addBook(new Book());
        }

        model.addAttribute("form", booksForm);

        return "/books/createBooksForm";
    }

    @GetMapping(value = "/edit")
    public String showEditForm(Model model) {
//        List<Book> books = new ArrayList<>();
//        bookService.findAll()
//                .iterator()
//                .forEachRemaining(books::add);

        model.addAttribute("form", new BooksCreationDto(books));

        return "/books/editBooksForm";
    }


    @PostMapping("/save")
    public String saveBooks(@ModelAttribute BooksCreationDto form, Model model, RedirectAttributes redirectAttributes) {
        // bookService.saveAll(form.getBooks());

        model.addAttribute("books", form.getBooks());
        redirectAttributes.addFlashAttribute("books", form.getBooks());
        return "redirect:/books/all";
    }




}
