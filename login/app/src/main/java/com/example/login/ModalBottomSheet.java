package com.example.login;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;

import android.os.StrictMode;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;


@SuppressLint("ValidFragment")
public class ModalBottomSheet extends BottomSheetDialogFragment {

    private int layoutStyle;
    Session session;

    @SuppressLint("ValidFragment")
    public ModalBottomSheet(int layoutStyle) {
        this.layoutStyle = layoutStyle;
    }


    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
       // View view = LayoutInflater.from(getContext()).inflate(R.layout.modal_bs_one,null);
        View view=View.inflate(getContext(), this.layoutStyle,null);
        if (this.layoutStyle == R.layout.modal_bs_one){
            view.findViewById(R.id.btnConfirmar).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                //////////////////////////////////////////////////////////////////////////////////////////////////////

                ///////////////////////////////////**__**////////////////////////////////////////////////////////////
                    Toast.makeText(getContext(),"has aceptado el pedido",Toast.LENGTH_SHORT).show();
                }
            });
            view.findViewById(R.id.btnCancelar).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),"has cancelado el pedido",Toast.LENGTH_SHORT).show();
                    Intent intento=new Intent(getContext(),Principal.class);
                    startActivity(intento);
                }
            });
        }
        dialog.setContentView(view);
    }
}
