package pl.giszka.bookweb;
import androidx.appcompat.app.ActionBar;

public class Helper {

    public static void setToolbarTile(ActionBar actionBar, String title) {
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

}
