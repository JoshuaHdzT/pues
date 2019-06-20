package com.example.login;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Pago extends AppCompatActivity implements View.OnClickListener {
TextView nombre,precio;
ImageView ImagenViewfoto;
Button btnPagoP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
        nombre=findViewById(R.id.tvNombrePedido);
        precio=findViewById(R.id.tvPrecioPedido);
        btnPagoP=findViewById(R.id.btnPagarP);
        btnPagoP.setOnClickListener(this);
        //ImagenViewfoto=findViewById(R.id.imageViewFoto);
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            String textView=extras.getString("nombre");
            String textView1=extras.getString("precio");
            String fotoo=extras.getString("foto");
            //Toast.makeText(getApplicationContext(),"Usted selecciono el siguiente platillo: "+ textView, Toast.LENGTH_SHORT).show();
            nombre.setText(textView);
            precio.setText(textView1);
           // ImagenViewfoto.setImageDrawable(Drawable.createFromPath(extras.getString("foto")));
        }

    }

    @Override
    public void onClick(View v) {

      //  lanzarSDBialogg(R.layout.modal_bs_one);
        Mail m = new Mail("hernandez.t.joshuamax@gmail.com", "motorola3100");

        String[] toArr = {"2517160096mhernandezt@gmail.com", "lala@lala.com"};
        try {
            m.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        m.set_to(toArr);
        // m.setFrom("wooo@wooo.com");
       // m.setSubject("This is an email sent using my Mail JavaMail wrapper from an Android device.");
        m.setBody("Email body.");

        try {
            m.addAttachment("/sdcard/filelocation");

            if(m.send()) {
               Toast.makeText(Pago.this, "Email was sent successfully.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(Pago.this, "Email was not sent.", Toast.LENGTH_LONG).show();
            }
        } catch(Exception e) {
            //Toast.makeText(MailApp.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show();
            Log.e("MailApp", "Could not send email", e);
        }

        }

    public void lanzarSDBialogg(int layoutStyle){
        BottomSheetDialogFragment bottomSheetDialogFragment=new ModalBottomSheet(layoutStyle);
        bottomSheetDialogFragment.setShowsDialog(true);
        bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
    }



}

