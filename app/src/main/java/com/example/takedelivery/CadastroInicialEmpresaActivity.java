package com.example.takedelivery;

import android.content.Intent;
import android.os.Bundle;

import com.example.takedelivery.model.Empresa;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroInicialEmpresaActivity extends AppCompatActivity {

    EditText editTextNome, editTextEmail, editTextSenha;
    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_inicial_empresa);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextNome = findViewById(R.id.editTextTextNomeResp);
        editTextEmail = findViewById(R.id.editTextTextEmailEmp);
        editTextSenha = findViewById(R.id.editTextTextSenhaEmp);
    }

    public void cadastrarUsuario(Empresa empresa){

        autenticacao = FirebaseItems.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                empresa.getEmail(), empresa.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if ( task.isSuccessful() ){
//                    Toast.makeText(CadastroInicialEmpresaActivity.this, "Sucesso ao cadastrar",
//                            Toast.LENGTH_SHORT).show();
//                    finish();
                    continuarCadastro(empresa);
                    try {

                        String identificadorUsuario = CryptographyBase64.codificarBase64( empresa.getEmail() );
                        empresa.setId( identificadorUsuario );
                        empresa.salvar();

                    }catch (Exception e){
                        e.printStackTrace();
                    }


                }else {

                    String excecao = "";
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        excecao = "Digite uma senha mais forte!";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "Digite um e-mail válido";
                    } catch (FirebaseAuthUserCollisionException e) {
                        excecao = "Esta conta existe";
                    } catch (Exception e) {
                        excecao = "Erro ao cadastrar: " + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroInicialEmpresaActivity.this,
                            excecao,
                            Toast.LENGTH_SHORT).show();

                }
            }

        });
    }

    public void validarCadastroEmpresa(View view){

        String textoNome  = editTextNome.getText().toString();
        String textoEmail = editTextEmail.getText().toString();
        String textoSenha = editTextSenha.getText().toString();

        if( !textoNome.isEmpty() ){
            if( !textoEmail.isEmpty() ){
                if ( !textoSenha.isEmpty() ){

                    Empresa empresa = new Empresa();
                    empresa.setNome( textoNome );
                    empresa.setEmail( textoEmail );
                    empresa.setSenha( textoSenha );

                    cadastrarUsuario( empresa );

                }else {
                    Toast.makeText(CadastroInicialEmpresaActivity.this,
                            "Preencha a senha",
                            Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(CadastroInicialEmpresaActivity.this,
                        "Preencha o email",
                        Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(CadastroInicialEmpresaActivity.this,
                    "Preencha o nome",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void continuarCadastro(Empresa empresa){
        Intent intent = new Intent( this, CadastroEmpresaActivity.class );
        CadastroEmpresaActivity.empresa = empresa;
        startActivity(intent);
    }


}