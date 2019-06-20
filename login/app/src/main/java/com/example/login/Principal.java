package com.example.login;

import android.content.Intent;
import android.os.StrictMode;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerViewComida;
    private RecyclerViewAdaptor adaptadorComida;
    private TextView nombre;
    private Button pedir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        recyclerViewComida=findViewById(R.id.recycleViewcimida);
        recyclerViewComida.setLayoutManager(new LinearLayoutManager(this));

        adaptadorComida=new RecyclerViewAdaptor(obtenerDatos());
        recyclerViewComida.setAdapter(adaptadorComida);
        nombre=findViewById(R.id.tvNombre);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.usuario://icon del usuario
                Intent inten=new Intent(Principal.this,EditarPerfil.class);
                startActivity(inten);
                break;
            case R.id.Historial://icono del Historial
                Intent intento=new Intent(Principal.this,Historial.class);
                startActivity(intento);
                //intento.putExtra("nombre", nombre.getText());
                break;
        }
        return super.onOptionsItemSelected(item);
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

    public List<comidaModelo> obtenerComidasBD(){
        List<comidaModelo> comida=new ArrayList<>();
        try {
            Statement st=conexionBD().createStatement();
            ResultSet rs=st.executeQuery("select*from comida");
            while (rs.next()){
                comida.add(new comidaModelo(
                        rs.getString(2),rs.getString(3)
                        ,rs.getString(4),rs.getString(5),R.drawable.tunas));
            }
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return comida;
    }

    public List<comidaModelo> obtenerDatos(){
        List<comidaModelo> comida=new ArrayList<>();

                comida.add(new comidaModelo(
                        "enchiladas verdes","Es unplato de echiladas verdes siuzas con acompañamientos"
                        ,"60","comida",R.drawable.enchiladassiusas));
        comida.add(new comidaModelo(
                "Chicharron en salsa","Es un plato de Chicarron en salsa verde con acompañamientos"
                ,"75","comida",R.drawable.fonda));
        comida.add(new comidaModelo(
                "Mole","Mole con acompañamientos y una jarra de agua"
                ,"85","paquete",R.drawable.mole));

        return comida;
    }

    @Override
    public void onClick(View v) {

    }

}
