package pl.giszka.bookweb;

import java.util.Date;

public class Book {

     String title;
     String author;
     Date data;

     public Book(){};

     public Book (String title, String author, Date date){

         this.title = title;
         this.author = author;
         this.data = date;
     }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", data=" + data +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
