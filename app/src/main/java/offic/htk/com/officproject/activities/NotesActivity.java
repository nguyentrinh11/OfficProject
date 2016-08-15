package offic.htk.com.officproject.activities;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import offic.htk.com.officproject.R;
import offic.htk.com.officproject.adapters.VerticalRecyclerViewAdapter;
import offic.htk.com.officproject.base.BaseActivity;
import offic.htk.com.officproject.models.realm.File;
import offic.htk.com.officproject.models.realm.Note;

public class NotesActivity extends BaseActivity {

    RecyclerView vRecyclerView;
    VerticalRecyclerViewAdapter vAdapter;
    List<Note> mNoteList = new ArrayList<>();

    @Override
    protected void onCreate() {
        Note note = new Note();
        RealmList<File> file = new RealmList<>();
        File f = new File();
        f.setCdThumbnailUrl("asdfasdf");
        file.add(f);
        note.setFileList(file);
        mNoteList.add(note);
    }

    @Override
    protected void initComponents() {
        vRecyclerView = (RecyclerView) findViewById(R.id.rc_notes);
        vRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        vRecyclerView.setLayoutManager(llm);
        vAdapter = new VerticalRecyclerViewAdapter(this,mNoteList);
        vRecyclerView.setAdapter(vAdapter);
        // Setting RecyclerView
//        coursesRecyclerView.setHasFixedSize(true);
//        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//        coursesRecyclerView.setLayoutManager(llm);
// nuggetsList is an ArrayList of Custom Objects, in this case  Nugget.class
//        adapter = new CourseRVAdapter(getActivity(), nuggetsList);
//        coursesRecyclerView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_notes;
    }
}
