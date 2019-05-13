package bo.testigos_del_bitcoin.betsports.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import bo.testigos_del_bitcoin.betsports.models.User;

public class DatabaseHelper {
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context) {
        DataBase instancia = new DataBase(context);
        this.mDatabase = instancia.getWritableDatabase();
    }

    public void firstInsert(User user) {
        ContentValues valores = new ContentValues();
        valores.put("usuario", user.getNombreUsuario());
        valores.put("password", user.getPassword());
        valores.put("edad", user.getEdad());
        valores.put("email", user.getEmail());
        valores.put("monedas", 600);

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

    public int getMonedasDeUsuario(String usuario) {
        String[] params = new String[1];
        params[0] = usuario;
        Cursor cursor = this.mDatabase.rawQuery("SELECT monedas FROM usuarios WHERE usuario = ?", params);
        if (cursor.moveToFirst()) {
            return cursor.getInt(cursor.getColumnIndex("monedas"));
        } else {
            return 0;
        }
    }

    public int getId(String nombreUsuario){
        String[] paramas = new String[1];
        paramas[0] = nombreUsuario;
        Cursor cursor = this.mDatabase.rawQuery("SELECT id FROM usuarios WHERE usuario = ?", paramas);
        cursor.moveToFirst();
        return cursor.getInt(cursor.getColumnIndex("id"));


    }

    public void cambiarMonedasDeUsuario(String usuario, int monedas){
        this.mDatabase.execSQL("UPDATE usuarios SET  monedas = '" + monedas + "' WHERE usuario = '" + usuario +"'");
        //Cursor cursor = this.mDatabase.rawQuery("UPDATE usuarios SET  monedas = '" + monedas + "' WHERE usuario = '" + usuario +"'", null);
    }

    public void borrarTodosLosUsuarios(){
        this.mDatabase.execSQL("DELETE FROM usuarios");
    }

}
