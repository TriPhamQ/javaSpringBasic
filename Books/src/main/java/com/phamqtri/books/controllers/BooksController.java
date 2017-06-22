package com.phamqtri.books.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phamqtri.books.models.Book;
import com.phamqtri.books.services.BooksService;

@Controller
public class BooksController {
	private final BooksService booksService;
	
    public BooksController(BooksService booksService){
        this.booksService = booksService;
    }
    
    @RequestMapping("/books")
    public String books(Model model) {
        ArrayList<Book> books = booksService.allBooks();
        model.addAttribute("books", books);
        return "books";
    }
    
    @RequestMapping("/books/{index}")
    public String findBookByIndex(@PathVariable("index") long id, Model model) {
    	Book book = booksService.findBookByIndex(id);
    	model.addAttribute("book", book);
    	return "book";
    }
    
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
    	return "newBook";
    }
    
    @PostMapping("/books/new")
    public String createBook(@Valid Book book, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
        	redirectAttributes.addFlashAttribute("book", book);
            return "newBook";
        }
        else{
        	booksService.addBook(book);
            return "redirect:/books";
        }
    }
    
    @RequestMapping(value="/books/delete/{id}")
    public String destroyBook(@PathVariable("id") long id) {
        booksService.destroyBook(id);
        return "redirect:/books";
    }
}
