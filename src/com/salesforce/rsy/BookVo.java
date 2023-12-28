package com.salesforce.rsy;

public class BookVo {

	private int bookId;
	private String bookTitle;
	private String bookPubs;
	private String bookDate;
	private int authorId;
	private String authorName;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookPubs() {
		return bookPubs;
	}

	public void setBookPubs(String bookPubs) {
		this.bookPubs = bookPubs;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public BookVo(int bookId, String bookTitle, String bookPubs, String bookDate, int authorId) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookPubs = bookPubs;
		this.bookDate = bookDate;
		this.authorId = authorId;
	}

	public BookVo(int bookId, String bookTitle, String bookPubs, String bookDate, String authorName) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookPubs = bookPubs;
		this.bookDate = bookDate;
		this.authorName = authorName;
	}

	public BookVo() {

	}

	public String toString() {
		return "BookVo [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookPubs=" + bookPubs + ", bookDate="
				+ bookDate + ", authorId=" + authorId +"]";
	}

	public String toString(int i) {
		return "BookVo [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookPubs=" + bookPubs + ", bookDate="
				+ bookDate + ", authorName=" + authorName + "]";
	}

}
