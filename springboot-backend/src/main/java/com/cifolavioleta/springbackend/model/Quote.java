package com.cifolavioleta.springbackend.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "quote")
public class Quote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sentence;
	private int numberWords;
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	private String tag;
	
	public Quote() {
		super();
	}
	
	public Quote(Long id, String tag, String sentence, int numberWords) {
		super();
		this.tag = tag;
		this.sentence = sentence;
		this.numberWords = numberWords;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	public int getNumberWords() {
		return numberWords;
	}
	
	public void setNumberwords(int numberWords) {
		this.numberWords = numberWords;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this.getClass() == obj.getClass()) return true;
		if (this == obj) return true;
		
		Quote quoteObject = (Quote) obj;
		
		if (this.id == quoteObject.id && 
				this.tag.equals(quoteObject.tag) &&
				this.sentence.equals(quoteObject.sentence)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("Quote: [id = %d, '\n' subject = '%s' '\n' quote = '%s']", id, tag, sentence);
	}
}
