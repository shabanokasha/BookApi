package com.shaban.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shaban.model.Book;

@Repository
public class BookDAOImplem implements BookDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public int saveBook(Book book) {
		sessionfactory.getCurrentSession().save(book);
		return book.getId();
	}

	@Override
	public Book get(int id) {

		return sessionfactory.getCurrentSession().get(Book.class, id);
	}

	@Override
	public List<Book> list() {
		List<Book> lis = sessionfactory.getCurrentSession().createQuery("from Book").list();
		return lis;
	}

	@Override
	public void update(int id, Book book) {
		Session session = sessionfactory.getCurrentSession();
		Book old = session.byId(Book.class).load(id);
		old.setTitle(book.getTitle());
		old.setAuthor(book.getAuthor());
		session.flush();

	}

	@Override
	public void delete(int id) {
		Session session = sessionfactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		session.delete(book);
	}

}
