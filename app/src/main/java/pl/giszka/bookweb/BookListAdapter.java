package pl.giszka.bookweb;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder>{
    private List<Book> books;
    //Konstruktor klasy BookListAdapter
    public BookListAdapter(List <Book> books){
        this.books = books;

    }



    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        //Utworzenie inflatera oraz podłączenie layout book_list_element
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.book_list_element, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;


    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
            //Tworzenie obiektu klasy Book
        Book book = books.get(position);
        TextView title = holder.title;
        TextView author = holder.author;
        TextView data = holder.date;
        title.setText(book.getTitle());
        author.setText(book.getAuthor());
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        data.setText(format.format(book.getData()));
    }

    @Override
    public int getItemCount() {

      return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

    TextView title;
    TextView author;
    TextView date;


        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.text_view_title);
            author = (TextView) itemView.findViewById(R.id.text_view_author);
            date = (TextView) itemView.findViewById(R.id.text_view_data);

        }
    }

}
