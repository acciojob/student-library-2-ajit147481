package com.driver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "card", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("card")
    private Student student;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("card")
    private List<Book> books;

    public Card(){
        this.cardStatus = CardStatus.ACTIVATED;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Student getStudent() {
        return student;
    }
}
