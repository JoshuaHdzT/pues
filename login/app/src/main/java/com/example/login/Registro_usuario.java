package com.example.login;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Registro_usuario extends AppCompatActivity implements View.OnClickListener {
private EditText Nombre,ApellidoP,ApellidoM,Colonia,Calle,Contrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        Button Registrar=findViewById(R.id.registro);
        Nombre=findViewById(R.id.Nombre);
        ApellidoP=findViewById(R.id.Apellidop);
        ApellidoM=findViewById(R.id.Apellidom);
        Colonia=findViewById(R.id.Colonia);
        Calle=findViewById(R.id.Calle);
        Contrasena=findViewById(R.id.Contrasena);
        Registrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    RegistrarUsuario();
    }

    public void RegistrarUsuario(){
        try {
            PreparedStatement pst=conexionBD().prepareStatement("INSERT INTO sesion values(?,?,?)");
            pst.setString(1,null);
            pst.setString(2,Nombre.getText().toString());
            pst.setString(3,ApellidoP.getText().toString());

            pst.executeUpdate();
            Toast.makeText(getApplicationContext(), "Exito v; ", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "upssi "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

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
}
