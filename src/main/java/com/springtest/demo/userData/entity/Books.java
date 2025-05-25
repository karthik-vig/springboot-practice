package com.springtest.demo.userData.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
// import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Books {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookname;
    private String isbn;
    @ManyToMany
    @JoinTable(
        name = "accounts_books"
        // joinColumns = @JoinColumn("book_id"),
        // inverseJoinColumns = @JoinColumn("account_id") 
    )
    private Set<Accounts> accounts = new HashSet<>();

    @ManyToOne
    Publisher publisher = new Publisher();

    public Books() {}

    public Books(
        String bookname,
        String isbn
        // Set<Accounts> accounts
    ) {
        this.bookname = bookname;
        this.isbn = isbn;
        // this.accounts = accounts;
    }

    public Long getId() {
        return id;
    }

    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Set<Accounts> getAccounts() {
        return accounts;
    }
    public void setAccounts(Set<Accounts> accounts) {
        this.accounts = accounts;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Books other = (Books) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Books [bookname=" + bookname + ", isbn=" + isbn + "]";
    }

    
}
