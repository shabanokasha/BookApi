package com.shaban.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shaban.model.Book;
import com.shaban.services.BookServices;

@RestController
public class BookController {

	@Autowired
	private BookServices bookServices;
	
	
	//Get All Books
	@GetMapping("/api/book")
	public ResponseEntity<List<Book>> list(){
		
		List<Book> list=bookServices.list();
		
		return ResponseEntity.ok().body(list);
	}
	
	//Save Book
	@PostMapping("api/book")
	public ResponseEntity<?> save(@RequestParam Book book){
		int id=bookServices.saveBook(book);
		return ResponseEntity.ok().body("Book Saved Id= "+id);
	}
	
	//Get aSingle Book
	@GetMapping("/api/boo/{id}")
	public ResponseEntity<Book> get(@PathVariable("id") int id){
		Book book=bookServices.get(id);
		return ResponseEntity.ok().body(book);
	}
	
	//Update Book
	@PutMapping("/api/book/{id}")
	public ResponseEntity<?> update(@PathVariable int id ,@RequestBody Book book){
		bookServices.update(id, book);
		return ResponseEntity.ok().body("Book Has Been Updated");
	}
	
	//Delete Book
	@DeleteMapping("/api/book/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		bookServices.delete(id);
		
		return ResponseEntity.ok().body("Book Has Deleted");
	}
	
	
}
