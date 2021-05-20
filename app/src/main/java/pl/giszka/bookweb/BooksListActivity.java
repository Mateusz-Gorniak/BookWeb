package pl.giszka.bookweb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class BooksListActivity extends AppCompatActivity {

    List<Book> books = new ArrayList<>();
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    Date dt = format.parse("2005/01/10");
    Date dt1 = format.parse("1999/05/12");
    Date dt2 = format.parse("2011/11/05");
    Date dt3 = format.parse("1986/08/14");
    Date dt4 = format.parse("2004/12/16");
    Date dt5 = format.parse("2009/03/12");
    Date dt6 = format.parse("1995/02/23");
    Date dt7 = format.parse("1997/02/26");
    Date dt8 = format.parse("2012/07/09");
    Date dt9 = format.parse("2015/10/06");

    public BooksListActivity() throws ParseException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        Book book1 = new Book("Ekstermista", "Remigiusz Mróz",dt);
        Book book2 = new Book("Narnia", "C.S.Lewis",dt1);
        Book book3 = new Book("Pan Tadeusz", "Adam Mickiewicz",dt2);
        Book book4 = new Book("Wiedzmin", "Andrzej Sapkowski",dt3);
        Book book5 = new Book("Pies który jezdzil koleją", "Roman Pisarski",dt4);
        Book book6 = new Book("Balladyna", "Juliusz Słowacki",dt5);
        Book book7 = new Book("Lalka", "Bolesław Prus",dt6);
        Book book8 = new Book("Ogniem i mieczem", "Henryk Sienkiewicz",dt7);
        Book book9 = new Book("Ludzie bezdomni", "Stefan Żeromski",dt8);
        Book book10 = new Book("Katarynka", "Bolesław Prus",dt9);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);

    for(Book i : books){

        Log.d( "Lista zawiera ksiązki" , i.toString());

    }
    BookListAdapter bookListAdapter = new BookListAdapter(books);
    RecyclerView bookrecycler = (RecyclerView) findViewById(R.id.books_list_recycler_view);
    bookrecycler.setAdapter(bookListAdapter);
    bookrecycler.setLayoutManager(new LinearLayoutManager(this));
    }






}