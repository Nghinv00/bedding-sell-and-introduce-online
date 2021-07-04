package com.nghinv.beddingsellintroduce.common.clientFrom;

import com.nghinv.beddingsellintroduce.common.dto.Book;

import java.util.ArrayList;
import java.util.List;

//@NoArgsConstructor
//@AllArgsConstructor
public class BooksCreationDto {
    // default and parameterized constructor

    private List<Book> books;

    public BooksCreationDto() {
        this.books = new ArrayList<>();
    }

    public BooksCreationDto(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }
}
