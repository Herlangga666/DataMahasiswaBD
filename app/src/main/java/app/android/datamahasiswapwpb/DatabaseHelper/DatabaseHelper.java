package app.android.datamahasiswapwpb.DatabaseHelper;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import app.android.datamahasiswapwpb.Mahasiswa;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "db_mahasiswa";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS tbl_mahasiswa(" +
                "id INTEGER NOT NULL PRIMARY KEY ," +
                "nama varchar(200) NOT NULL," +
                "tgl_lahir datetime NOT NULL," +
                "jenkel varchar(200) NOT NULL," +
                "alamat varchar(200) NOT NULL" +
                ");";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = ("drop table if exists tbl_mahasiswa");
        db.execSQL(sql);
        onCreate(db);
    }


    public List<Mahasiswa> selectMahasiswa() {
        ArrayList<Mahasiswa> userList = new ArrayList<Mahasiswa>();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"*"};
        Cursor c = db.query("tbl_mahasiswa", columns, null, null, null, null, null);
        while (c.moveToNext()) {
            String name = c.getString(0);
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNama(name);
            userList.add(mahasiswa);
        }
        return userList;
    }


}
