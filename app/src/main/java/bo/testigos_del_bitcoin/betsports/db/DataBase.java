package bo.testigos_del_bitcoin.betsports.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import bo.testigos_del_bitcoin.betsports.Constants;

public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " usuario VARCHAR NOT NULL," +
                "password VARCHAR NOT NULL," +
                "edad INTEGER," +
                "email VARCHAR NOT NULL," +
                "monedas INTEGER NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
