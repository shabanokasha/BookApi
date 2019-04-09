package com.shaban.dao;

import java.util.List;

import com.shaban.model.Book;

public interface BookDAO {

	// Save The Record
	int saveBook(Book book);

	// Get Asingle Record
	Book get(int id);

	// Get All Record
	List<Book> list();

	// Update Record
	void update(int id, Book book);

	// Delete Record
	void delete(int id);

}
