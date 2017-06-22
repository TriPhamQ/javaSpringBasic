package com.phamqtri.books.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.phamqtri.books.models.Book;
import com.phamqtri.books.repositories.BookRepository;

@Service
public class BooksService {
	private ArrayList<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
            new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
            new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
            new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
            new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)
            ));
	private BookRepository bookRepository;
	
	public BooksService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
    
    public ArrayList<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    public Book findBookByIndex(long id) {
    	 return bookRepository.findOne(id);
    }
    
    public void addBook(Book book) {
        bookRepository.save(book);
    }
    
    public void destroyBook(long id) {
        if (bookRepository.findOne(id) != null){
            bookRepository.delete(id);
        }
    }
}
