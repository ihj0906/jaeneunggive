package dto;

import java.sql.Timestamp;

public class Exchange {
	private int no;
	private String give_talent1;
	private String give_talent2;
	private String wish_talent1;
	private String wish_talent2;
	private String id;
	private String subject;
	private String content;
	private String location;
	private String closing_date;
	private int app_progress;
	private String book_id;
	private int book_no;
	private Timestamp cre_date;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getGive_talent1() {
		return give_talent1;
	}
	public void setGive_talent1(String give_talent1) {
		this.give_talent1 = give_talent1;
	}
	public String getGive_talent2() {
		return give_talent2;
	}
	public void setGive_talent2(String give_talent2) {
		this.give_talent2 = give_talent2;
	}
	public String getWish_talent1() {
		return wish_talent1;
	}
	public void setWish_talent1(String wish_talent1) {
		this.wish_talent1 = wish_talent1;
	}
	public String getWish_talent2() {
		return wish_talent2;
	}
	public void setWish_talent2(String wish_talent2) {
		this.wish_talent2 = wish_talent2;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getClosing_date() {
		return closing_date;
	}
	public void setClosing_date(String closing_date) {
		this.closing_date = closing_date;
	}
	public int getApp_progress() {
		return app_progress;
	}
	public void setApp_progress(int app_progress) {
		this.app_progress = app_progress;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public Timestamp getCre_date() {
		return cre_date;
	}
	public void setCre_date(Timestamp cre_date) {
		this.cre_date = cre_date;
	}
		
}
