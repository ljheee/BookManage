package com.ljheee.app.db;

import java.util.LinkedList;
import java.util.List;

import com.ljheee.app.entity.Book;
/**
 * 操作数据库
 * @author ljheee
 * 此用  List 替代数据库操作
 *
 */
public class Db {
	private static LinkedList<Book> bookTable;

	static{
		bookTable = new LinkedList<>();
		bookTable.add(new Book("ljh", "000", 19));
		bookTable.add(new Book("ljh2", "0002", 19));
		bookTable.add(new Book("ljh3", "0003", 19));
		bookTable.add(new Book("ljh4", "0004", 19));
	}

	public static void save(Book b){
		bookTable.add(b);
	}
	
 	/**
 	 * 根据ID 查找book
 	 * @param id
 	 * @return
 	 */
	public static Book find(long id){
		Book book = null;
		
		for (Book b : bookTable) {
			if(id==b.getId()){
				book = b;
				break;
			}
		}
		return book;
	}
	
	public static List<Book> find(){
		return bookTable;
	}

	public static void remove(long id){
		for (int i = 0; i < bookTable.size(); i++) {
			Book b = bookTable.get(i);
			if(id==b.getId()) {
				bookTable.remove(b);
				break;
			}
		}
	}
	public static void update(Book book){
		
		for (int i = 0; i < bookTable.size(); i++) {
			Book bb = bookTable.get(i);
			
			if(bb.getId()==book.getId()){
				bookTable.set(i, book);
				break;
			}
		}
		
		
	}
	
}
