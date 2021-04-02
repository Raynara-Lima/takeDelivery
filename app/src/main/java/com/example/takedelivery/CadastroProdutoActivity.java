package com.example.takedelivery;

import android.content.Intent;
import android.os.Bundle;

import com.example.takedelivery.model.Produto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class CadastroProdutoActivity extends AppCompatActivity {
    EditText editTextNome;
    EditText editTextDescricao;
    EditText editTextPreco;

    boolean edit;
    String idProdutoEditar;
    int id;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance ();
    private DatabaseReference mDatabaseReference = mDatabase.getReference ();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextNome = findViewById( R.id.editTextNome );
        editTextDescricao = findViewById( R.id.editTextDescricao );
        editTextPreco = findViewById( R.id.editTextPreco );

        edit = false;

        if( getIntent().getExtras() != null ){
            if(getIntent().getExtras().get( "id" ) != null) id = (int) getIntent().getExtras().get( "id" );
            String nome = (String) getIntent().getExtras().get( "nome" );
            String descricao = (String) getIntent().getExtras().get( "descricao" );
            Float preco = (Float) getIntent().getExtras().get( "preco" );
            if( getIntent().getExtras().get( "idEdit" ) != null) idProdutoEditar =  getIntent().getExtras().get( "idEdit" ).toString();
            editTextNome.setText(nome);
            editTextDescricao.setText(descricao);
            editTextPreco.setText(String.valueOf(preco));

            if(idProdutoEditar != null) edit = true;
        }

    }

    public void cancelar( View view ){
        setResult( Constants.RESULT_CANCEL );
        finish();
    }

    public void adicionar( View view ){
        Intent intent = new Intent();

        String nome = editTextNome.getText().toString();
        String descricao = editTextDescricao.getText().toString();
        String preco = editTextPreco.getText().toString();

        intent.putExtra("nome", nome );
        intent.putExtra("descricao", descricao );
        intent.putExtra("preco", preco );
        if(edit) {
            intent.putExtra("id", idProdutoEditar);
            mDatabaseReference = mDatabase.getReference ().child ("produtos").child(idProdutoEditar);
            mDatabaseReference.child("nome").setValue(nome);
            mDatabaseReference.child("descricao").setValue(descricao);
            mDatabaseReference.child("preco").setValue( new Float(preco));


        }else{
            Produto produto = new Produto(id, nome, descricao, new Float(preco));
            mDatabaseReference = mDatabase.getReference ().child ("produtos").child(String.valueOf(id));
            mDatabaseReference.setValue (produto);

        }
        setResult( Constants.RESULT_ADD, intent );
        finish();
    }

}