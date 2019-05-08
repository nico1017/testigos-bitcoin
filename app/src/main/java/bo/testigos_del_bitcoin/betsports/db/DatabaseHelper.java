package bo.testigos_del_bitcoin.betsports.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import bo.testigos_del_bitcoin.betsports.models.User;

public class DatabaseHelper {
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context){
        DataBase instancia = new DataBase(context);
        this.mDatabase = instancia.getWritableDatabase();
    }

    public void insert(User user){
        ContentValues valores = new ContentValues();
        valores.put("usuario", user.getNombreUsuario());
        valores.put("password", user.getPassword());
        valores.put("edad", user.getEdad());
        valores.put("email", user.getEmail());
        valores.put("monedas", user.getMonedas());

        this.mDatabase.insert("usuarios", null, valores);
        this.mDatabase.close();
    }

    public boolean login(String usuario, String password) {
        //Parametros en String array
        String[] params = new String[2];
        params[0] = usuario;
        params[1] = password;

        Cursor cursor = this.mDatabase.rawQuery("SELECT * FROM usuarios WHERE usuario = ? AND password = ?", params);

        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }
    }
}
