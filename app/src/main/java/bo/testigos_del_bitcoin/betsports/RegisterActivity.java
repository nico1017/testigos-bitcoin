package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Layout;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    }
}
