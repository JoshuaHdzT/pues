package com.example.login;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Historial extends AppCompatActivity {
    private RecyclerView recyclerViewComida;
    private RecyclerViewAdaptor2 adaptadorComida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        recyclerViewComida=findViewById(R.id.recycleViewHistoriaC);
        recyclerViewComida.setLayoutManager(new LinearLayoutManager(this));

        adaptadorComida=new RecyclerViewAdaptor2(obtenerDatos());
        recyclerViewComida.setAdapter(adaptadorComida);


    }

    public Connection conexionBD() {
        Connection conexion = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.68:3306/restaurant", "root", "");
//Telefono 192.168.43.36 casa 192.168.1.68

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            // System.out.println("eeeeeeeeeeeerrrrrrrrrroooooorrr "+e.getMessage());
        }
        return conexion;
    }

    private List<comidaModelo> obtenerHistorialBD() {
        List<comidaModelo> comida=new ArrayList<>();
        try {
            Statement st=conexionBD().createStatement();
            ResultSet rs=st.executeQuery("select*from comida");
            while (rs.next()){
                comida.add(new comidaModelo(
                        rs.getString(2),rs.getString(3)
                        ,rs.getString(4),rs.getString(5),R.drawable.enchiladassiusas));
            }
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return comida;
    }

    public List<comidaModelo> obtenerDatos(){
        List<comidaModelo> comida=new ArrayList<>();

        comida.add(new comidaModelo(
                "Chicharron en salsa","75"
                ,"Es unplato de Chicarron en salsa verde con acompañamientos","comida",R.drawable.fonda));
        comida.add(new comidaModelo(
                "Mole","85"
                ,"Mole con acompañamientos y una jarra de agua","paquete",R.drawable.mole));

        return comida;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_historoal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.valorar://icon del usuario
                Intent intento=new Intent(Historial.this,Valorar_servicio.class);
                startActivity(intento);
                //intento.putExtra("nombre", nombre.getText());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
