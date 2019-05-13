package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Layout;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import bo.testigos_del_bitcoin.betsports.db.DatabaseHelper;
import bo.testigos_del_bitcoin.betsports.models.User;

public class RegisterActivity extends AppCompatActivity {
    Context mContext;

    private LinearLayout padre;
    private TextView titulo;

    private TextView usuarioText;
    private EditText usuario;

    private TextView passwordText;
    private EditText password;

    private TextView edadText;
    private EditText edad;

    private TextView mailText;
    private EditText mail;

    private LinearLayout condiciones;
    private CheckBox checkbox;
    private TextView condicionesText;

    private LinearLayout botones;
    private Button registrar;
    private Button limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        padre = new LinearLayout(mContext);
        padre.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        padre.setOrientation(LinearLayout.VERTICAL);
        padre.setBackground(getDrawable(R.drawable.background));
        padre.setPadding(25, 25, 25, 25);

        titulo = new TextView(mContext);
        titulo.setText(getText(R.string.titulo));
        titulo.setTextSize(26);
        titulo.setTextColor(getColor(R.color.white));
        titulo.setGravity(Gravity.CENTER_HORIZONTAL);
        padre.addView(titulo);

        usuarioText = new TextView(mContext);
        usuarioText.setText(getString(R.string.usuariotxt));
        usuarioText.setTextSize(20);
        usuarioText.setTextColor(getColor(R.color.white));
        usuarioText.setPadding(0,20,0,0);
        padre.addView(usuarioText);

        usuario = new EditText(mContext);
        usuario.setHint("Ingrese su Usuario");
        usuario.setTextColor(getColor(R.color.white));
        usuario.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        usuario.setMaxLines(1);
        usuario.setInputType(InputType.TYPE_CLASS_TEXT);
        padre.addView(usuario);

        passwordText = new TextView(mContext);
        passwordText.setText(getString(R.string.passwordtxt));
        passwordText.setTextSize(20);
        passwordText.setTextColor(getColor(R.color.white));
        passwordText.setPadding(0,20,0,0);
        padre.addView(passwordText);

        password = new EditText(mContext);
        password.setHint("Ingrese su Contraseña");
        password.setTextColor(getColor(R.color.white));
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        padre.addView(password);

        edadText = new TextView(mContext);
        edadText.setText(getString(R.string.edadtxt));
        edadText.setTextSize(20);
        edadText.setTextColor(getColor(R.color.white));
        edadText.setPadding(0,20,0,0);
        padre.addView(edadText);

        edad = new EditText(mContext);
        edad.setTextColor(getColor(R.color.white));
        edad.setInputType(InputType.TYPE_CLASS_NUMBER);
        edad.setHint("Ingrese su Edad");
        int max = 2;
        edad.setFilters(new InputFilter[]{new InputFilter.LengthFilter(max)});
        padre.addView(edad);

        mailText = new TextView(mContext);
        mailText.setText(getString(R.string.mailtxt));
        mailText.setTextSize(20);
        mailText.setTextColor(getColor(R.color.white));
        mailText.setPadding(0,20,0,0);
        padre.addView(mailText);

        mail = new EditText(mContext);
        mail.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        mail.setTextColor(getColor(R.color.white));
        mail.setHint("Ingrese su e-mail");
        padre.addView(mail);

        condiciones = new LinearLayout(mContext);
        condiciones.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        condiciones.setOrientation(LinearLayout.HORIZONTAL);
        condiciones.setPadding(0,20,0,0);

        checkbox = new CheckBox(mContext);
        condiciones.addView(checkbox);

        condicionesText = new TextView(mContext);
        condicionesText.setText(getString(R.string.condiciones));
        condicionesText.setTextSize(20);
        condicionesText.setTextColor(getColor(R.color.white));
        condicionesText.setPadding(20,0,0,0);
        condiciones.addView(condicionesText);

        padre.addView(condiciones);

        botones = new LinearLayout(mContext);
        botones.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        botones.setPadding(0,50,0,0);
        botones.setOrientation(LinearLayout.HORIZONTAL);

        registrar = new Button(mContext);
        registrar.setText(getString(R.string.botonRgistrar));
        registrar.setLayoutParams(new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1));
        registrar.setTextSize(20);
        registrar.setGravity(Gravity.CENTER);
        registrar.setPadding(30,30,30,30);
        registrar.setBackground(getDrawable(R.drawable.background_botones));
        registrar.setTextColor(getColor(R.color.white));
        botones.addView(registrar);

        limpiar = new Button(mContext);
        limpiar.setText(getString(R.string.botonLimpiar));
        limpiar.setLayoutParams(new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1));
        limpiar.setTextSize(20);
        limpiar.setGravity(Gravity.CENTER);
        limpiar.setPadding(30,30,30,30);
        limpiar.setBackground(getDrawable(R.drawable.background_botones));
        limpiar.setTextColor(getColor(R.color.white));
        botones.addView(limpiar);

        padre.addView(botones);

        setContentView(padre);

        addEvents();
    }

    public void addEvents(){
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarFormulario();
            }
        });

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setText("");
                password.setText("");
                edad.setText("");
                mail.setText("");
            }
        });
    }

    public void validarFormulario(){
        if(usuario.getText().toString().isEmpty()){
            usuario.setError("Ingrese un usuario por favor");
            return;
        }

        if(password.getText().toString().isEmpty()){
            password.setError("Ingrese una contraseña por favor");
            return;
        }

        if(edad.getText().toString().isEmpty()){
            edad.setError("Ingrese su edad por favor");
            return;
        }

        if(mail.getText().toString().isEmpty()){
            mail.setError("Ingrese un mail por favor");
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(mail.getText().toString()).matches()){
            mail.setError("Ingrese un e-mail válido por favor");
            return;
        }

        if(!checkbox.isChecked()){
            Toast.makeText(mContext,"Por favor acepte los Términos y Condiciones",Toast.LENGTH_LONG).show();
            return;
        }

        User usuarioParaEnviar = new User();
        usuarioParaEnviar.setNombreUsuario(usuario.getText().toString());
        usuarioParaEnviar.setPassword(password.getText().toString());
        usuarioParaEnviar.setEdad(Integer.parseInt(edad.getText().toString()));
        usuarioParaEnviar.setEmail(mail.getText().toString());
        usuarioParaEnviar.setMonedas(600);

        DatabaseHelper dbHelper = new DatabaseHelper(mContext);
        dbHelper.firstInsert(usuarioParaEnviar);
        //usuarioParaEnviar.setId(dbHelper.getId(usuarioParaEnviar.getNombreUsuario()));

        //llenarPreferences(usuario.getText().toString(), password.getText().toString());

        String json = new Gson().toJson(usuarioParaEnviar);

        Intent intent = new Intent();
        intent.putExtra(Constants.CODIGO_REGISTRAR_USUARIO, json);
        setResult(RESULT_OK, intent);
        finish();

    }

    public void llenarPreferences(String us,String pass){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(Constants.PREF_USER, us);
        editor.putString(Constants.PREF_PASS, pass);
        editor.apply();
    }


}
