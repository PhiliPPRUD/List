package my.application.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import my.application.list.Adapter.NotesListAdapter;
import my.application.list.DataBase.RoomDB;
import my.application.list.Models.Notes;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fab_add;
    NotesListAdapter notesListAdapter;
    RoomDB datebase;
    List<Notes> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_home);
        fab_add = findViewById(R.id.fab_add);
        datebase = RoomDB.getInstance(this);
        notes = datebase.mainDAO.getAll();

        updateRecyclre(notes);
    }

    private void updateRecyclre(List<Notes> notes) {
        recyclerView.setHasFixedSize(true);
        notesListAdapter = new NotesListAdapter(MainActivity.this, notes, );

    }
    private final NotesClickListener notesClickListener = new NotesClickListener();
}