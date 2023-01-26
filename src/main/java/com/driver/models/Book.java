package com.driver.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("booksWritten")
    private Author author;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("books")
    private Card card;


    @Column(columnDefinition = "TINYINT(1)")
    private boolean available;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("book")
    private List<Transaction> transactions;

    public Book() {
    }
    public Book(String name,Genre genre,Author author) {
        this.author=author;
        this.genre=genre;
        this.name=name;
        this.available=true;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public Card getCard() {
        return card;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Genre getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return available;
    }
}

