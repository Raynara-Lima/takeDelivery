package com.example.takedelivery;

import android.content.Intent;
import android.os.Bundle;

import com.example.takedelivery.model.Categoria;
import com.example.takedelivery.model.Empresa;
import com.example.takedelivery.model.Produto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import com.example.takedelivery.model.Produto;
public class EmpresaActivity extends AppCompatActivity {
    Empresa empresa = new Empresa("28.046.882/0001-45", "Delivrey Menu", "8599568791", "60125151", "CE", "Fortaleza", "Dionisio Torres", "Osvaldo Cruz", "2085", Categoria.BRASILEIRA);
    ArrayList<Produto> cardapio = new ArrayList<Produto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cardapio.add(new Produto("Vatapá de frango","Acompanha arroz branco e farofinha de mandioca. Vatapá de frando desfiado e finalizado com batata palha.", new BigDecimal(19.90)));
        cardapio.add(new Produto("Frango com salsa de ervas frescas","Acompanha arroz branco e purê de batatas. Filé de peito de frango em tiras adicnado de molho a base de azeite com ervas frescas.", new BigDecimal(19.90)));

        empresa.setCardapio(cardapio);

        TextView nome = findViewById( R.id.textViewNome);;
        nome.setText(empresa.getNomeFantasia());

    }
        public void verCardapio (View view){
            Intent intent = new Intent(this, CardapioActivity.class);
            CardapioActivity.cardapio = empresa.getCardapio();
//            intent.putParcelableArrayListExtra( "cardapio", (ArrayList<? extends Parcelable>) cardapio);
            startActivity(intent);

        }

}