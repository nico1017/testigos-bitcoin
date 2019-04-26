package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import bo.testigos_del_bitcoin.betsports.models.User;

public class LoginActivity extends AppCompatActivity {

    private Context mContext;

    private EditText usuario;
    private EditText password;
    private Button ingresar;
    private Button registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;

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
               //TODO Conectar con la paginaprincipal
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
                    User ususarioRecivido = new Gson().fromJson(json, User.class);
                    usuario.setText(ususarioRecivido.getNombreUsuario());
                    password.setText(ususarioRecivido.getPassword());
                }
            }
        }
    }
}
