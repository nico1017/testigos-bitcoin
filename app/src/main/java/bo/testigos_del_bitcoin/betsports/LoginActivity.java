package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import bo.testigos_del_bitcoin.betsports.db.DatabaseHelper;
import bo.testigos_del_bitcoin.betsports.models.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;

    private boolean recienRegistrado;

    private EditText usuario;
    private EditText password;
    private Button ingresar;
    private Button registrarse;
    private User ususarioRecivido;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;
        recienRegistrado = false;

        dbHelper = new DatabaseHelper(mContext);

        initViews();
        addEvents();
    }

    public void initViews(){
        usuario = findViewById(R.id.usuario_login);
        password = findViewById(R.id.password_login);
        ingresar = findViewById(R.id.ingresar);
        registrarse = findViewById(R.id.registrarse);
    }

    public void addEvents(){
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usVerficar = usuario.getText().toString();
                String passVerificar = password.getText().toString();

                if(validarUsuario(usVerficar, passVerificar)){
                    if(recienRegistrado) {
                        //Toast.makeText(mContext, "ChooseSports", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(mContext, ChooseSportActivity.class);
                        intent.putExtra(Constants.CODIGO_PASAR_A_CHOOSE, usVerficar);
                        startActivity(intent);

                    }else {
                        //Toast.makeText(mContext, "MainMenu", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(mContext, MainMenuActivity.class);
                        intent.putExtra(Constants.CODIGO_PASAR_A_MAINMENU, usVerficar);
                        startActivity(intent);
                    }
                }else{
                    Toast.makeText(mContext, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
                }
            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, RegisterActivity.class);
                startActivityForResult(intent, Constants.CODIGO_TANSACCION_REGISTER);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == Constants.CODIGO_TANSACCION_REGISTER){
            if (resultCode == RESULT_OK){
                if(data != null){
                    String json = data.getStringExtra(Constants.CODIGO_REGISTRAR_USUARIO);
                    ususarioRecivido = new Gson().fromJson(json, User.class);
                    usuario.setText(ususarioRecivido.getNombreUsuario());
                    password.setText(ususarioRecivido.getPassword());
                    recienRegistrado = true;
                }
            }
        }
    }

    public boolean validarUsuario(String us, String pass){

        if(us == null || us.isEmpty()){
            return false;
        }

        if(pass == null || pass.isEmpty()){
            return false;
        }

        /*SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        String usGuardado = prefs.getString(Constants.PREF_USER, "");
        String passGuardada = prefs.getString(Constants.PREF_PASS, "");
        return us.equals(usGuardado) && pass.equals(passGuardada);*/

        return dbHelper.login(us, pass);
    }

    @Override
    public void onClick(View v) {
        //url del facebook oficial
        String url = "https://www.facebook.com/BetSports-852952505043115/?modal=admin_todo_tour";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);

    }
}
