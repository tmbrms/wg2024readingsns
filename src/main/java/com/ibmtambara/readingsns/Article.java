package com.ibmtambara.readingsns;

import java.time.Instant;

public class Article {
    public User user;
    public Book book;
    public Message message;

    public Article(){
        this.user = new User();
        this.book = new Book();
        this.message = new Message();
    }

    public void setUser(String name, String icon){
        user.name = name;
        user.icon = icon;
    }

    public void setBook(String name, String isbn){
        book.name = name;
        book.isbn = isbn;
    }

    public void setMessage(String content, String timestamp){
        message.content = content;
        message.timestamp = Instant.parse(timestamp);
    }
    
    public class User {
        public String name;
        public String icon;

        public User(){
            this.name = "";
            this.icon = "no_photo.png";
        }
    }

    public class Book {
        public String name;
        public String isbn;

        public Book(){
            this.name = "";
            this.isbn = "";
        }
    }

    public class Message {
        public String content;
        public Instant timestamp;

        public Message(){
            this.content = "";
            this.timestamp = Instant.now();
        }
    }
}
