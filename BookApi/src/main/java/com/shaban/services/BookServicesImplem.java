package com.shaban.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shaban.dao.BookDAO;
import com.shaban.model.Book;

@Service
public class BookServicesImplem implements BookServices {

	@Autowired
	BookDAO bookDao;
	
	@Override
	@Transactional
	public int saveBook(Book book) {
		
		return bookDao.saveBook(book);
	}

	@Override
	@Transactional
	public Book get(int id) {
		
		return bookDao.get(id);
	}

	@Override
	@Transactional
	public List<Book> list() {
		
		return bookDao.list();
	}

	@Override
	@Transactional
	public void update(int id, Book book) {
		bookDao.update(id, book);

	}

	@Override
	@Transactional
	public void delete(int id) {
		bookDao.delete(id);

	}

}
