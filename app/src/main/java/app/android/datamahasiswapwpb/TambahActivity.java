package app.android.datamahasiswapwpb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import app.android.datamahasiswapwpb.DatabaseHelper.DatabaseHelper;

import static android.content.Context.MODE_PRIVATE;

public class TambahActivity extends AppCompatActivity {

    EditText eNama ,eTglLahir , eJenkel , eAlamat;
    Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        eNama = (EditText)findViewById(R.id.eNama);
        eTglLahir = (EditText)findViewById(R.id.eTglLahir);
        eJenkel = (EditText)findViewById(R.id.eJenkel);
        eAlamat = (EditText)findViewById(R.id.eAlamat);
        btnTambah = (Button)findViewById(R.id.btnAddData);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(TambahActivity.this);
                Mahasiswa mahasiswa = new Mahasiswa();
                String nama = eNama.getText().toString().trim();
                mahasiswa.setNama(nama);
                String tgl_lahir = eTglLahir.getText().toString().trim();
                mahasiswa.setTgl_lahir(tgl_lahir);
                String jenkel = eJenkel.getText().toString().trim();
                mahasiswa.setJenkel(jenkel);
                String alamat = eAlamat.getText().toString().trim();
                mahasiswa.setAlamat(alamat);

                databaseHelper.insert(mahasiswa);


                Toast.makeText(TambahActivity.this , "Data Berhasil Di Input" , Toast.LENGTH_SHORT).show();
            }
        });

    }

}
