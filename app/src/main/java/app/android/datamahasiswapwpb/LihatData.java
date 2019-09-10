package app.android.datamahasiswapwpb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import app.android.datamahasiswapwpb.DatabaseHelper.DatabaseHelper;

public class LihatData extends AppCompatActivity {

    RecyclerView reMahasiswa;
    RecyclerView.LayoutManager layoutManager;
    List<Mahasiswa> listMahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        reMahasiswa=(RecyclerView)findViewById(R.id.reDataMahasiswa);
        layoutManager=new LinearLayoutManager(LihatData.this);
        reMahasiswa.setLayoutManager(layoutManager);

        setupRecyclerView();

    }

    private void setupRecyclerView() {
        DatabaseHelper db=new DatabaseHelper(LihatData.this);
        listMahasiswa=db.selectMahasiswa();
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(LihatData.this,listMahasiswa);
        reMahasiswa.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
