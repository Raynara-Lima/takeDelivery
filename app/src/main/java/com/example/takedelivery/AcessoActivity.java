package com.example.takedelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.takedelivery.model.Empresa;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class AcessoActivity extends AppCompatActivity {
    private EditText email, senha;
    private FirebaseAuth autenticar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acesso);
        autenticar = FirebaseItems.getFirebaseAutenticacao();


        email = findViewById(R.id.editTextTextEmailLog);
        senha = findViewById(R.id.editTextTextPassLog);

    }


    public void logarEmpresa(Empresa empresa) {

        autenticar.signInWithEmailAndPassword(
                empresa.getEmail(), empresa.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    abrirTelaEmpresa();
                } else {

                    String excecao = "";
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e) {
                        excecao = "Usuário não cadastrado.";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "Email e senha não correspondem";
                    } catch (Exception e) {
                        excecao = "Erro ao cadastrar usuário: " + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(AcessoActivity.this,
                            excecao,
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void validarAutenticacaoEmpresa(View view) {

        String textoEmail = email.getText().toString();
        String textoSenha = senha.getText().toString();

        if (!textoEmail.isEmpty()) {
            if (!textoSenha.isEmpty()) {

                Empresa empresa = new Empresa();
                empresa.setEmail(textoEmail);
                empresa.setSenha(textoSenha);

                logarEmpresa(empresa);

            } else {
                Toast.makeText(AcessoActivity.this,
                        "Preencha a senha!",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(AcessoActivity.this,
                    "Preencha o email!",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void abrirTelaEmpresa() {
        Intent intent = new Intent(this, EmpresaActivity.class);
        startActivity(intent);
    }

    public void cadastroEmpresa(View view){
        Intent intent = new Intent(this, CadastroInicialEmpresaActivity.class);
        startActivity(intent);
    }
}