package com.library.beans;

public class Book {
	private String bookId;
	private String bookName;
	private String author;
	private String yop;
	private String addedBy;
	
	public Book()
	{
		
	}
	public Book(String bookId,String bookName,String author, String yop, String addedBy)
	{
		this.bookId=bookId;
		this.bookName=bookName;
		this.author=author;
		this.yop=yop;
		this.addedBy=addedBy;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getYop() {
		return yop;
	}
	public void setYop(String yop) {
		this.yop = yop;
	}
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	
	
	

}
