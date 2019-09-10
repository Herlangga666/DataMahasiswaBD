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

public class TambahActivity extends AppCompatActivity {
    public static final String DATABASE_NAME = "db_mahasiswa";
    SQLiteDatabase db;
    EditText eNama ,eTglLahir , eJenkel , eAlamat;
    Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        db = openOrCreateDatabase(DATABASE_NAME , MODE_PRIVATE , null);
        createTable();
        eNama = (EditText)findViewById(R.id.eNama);
        eTglLahir = (EditText)findViewById(R.id.eTglLahir);
        eJenkel = (EditText)findViewById(R.id.eJenkel);
        eAlamat = (EditText)findViewById(R.id.eAlamat);
        btnTambah = (Button)findViewById(R.id.btnAddData);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(TambahActivity.this);
                databaseHelper.onCreate(db);
                String nama = eNama.getText().toString().trim();
                String tgl_lahir = eTglLahir.getText().toString().trim();
                String jenkel = eJenkel.getText().toString().trim();
                String alamat = eAlamat.getText().toString().trim();

                String sql = "INSERT INTO tbl_mahasiswa(nama , tgl_lahir , jenkel , alamat)" +
                        "VALUES (? , ? , ? , ?)";

                db.execSQL(sql , new String[]{nama , tgl_lahir , jenkel , alamat});
                Toast.makeText(TambahActivity.this , "Data Berhasil Di Input" , Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS tbl_mahasiswa(" +
                "id INTEGER NOT NULL CONSTRAINT tbl_mahasiswa_pk PRIMARY KEY ," +
                "nama varchar(200) NOT NULL," +
                "tgl_lahir datetime NOT NULL," +
                "jenkel varchar(200) NOT NULL," +
                "alamat varchar(200) NOT NULL" +
                ");";

        db.execSQL(sql);
    }

}
