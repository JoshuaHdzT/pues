package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private TextView Respuesta;
    Button Inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Inicio = (Button) findViewById(R.id.buttonInicio);
        mPasswordView=findViewById(R.id.email);
        mEmailView=findViewById(R.id.password);
        Respuesta=findViewById(R.id.respuesta);
        Inicio.setOnClickListener(this);
        Respuesta.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.buttonInicio){//si el boton Inicio se preciona
            Intent intent=new Intent(LoginActivity.this,Principal.class);
            startActivity(intent);//inicia el intento
        }
        if (id==R.id.respuesta) {//si se preciona registrarse
            Intent intent=new Intent(LoginActivity.this,Registro_usuario.class);
            startActivity(intent);//inicia el intento
        }
    }//fin OnClick

    public Connection conexionBD() {
        Connection conexion = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.68:3306/libreriaf", "root", "");

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return conexion;
    }

    public void agregar(){
        try {
            PreparedStatement pst=conexionBD().prepareStatement("INSERT INTO sesion values(?,?,?)");
            pst.setString(1,null);
            pst.setString(2,mPasswordView.getText().toString());
            pst.setString(3,mEmailView.getText().toString());

            pst.executeUpdate();
            Toast.makeText(getApplicationContext(), "Exito v; ", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "upssi "+e.getMessage(), Toast.LENGTH_SHORT).show();
            Respuesta.setText(e.getMessage());
        }
    }


}


