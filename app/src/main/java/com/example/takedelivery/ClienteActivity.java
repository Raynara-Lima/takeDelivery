package com.example.takedelivery;

import android.content.Intent;
import android.os.Bundle;

import com.example.takedelivery.adapter.AdapterListViewEmpresas;
import com.example.takedelivery.model.Categoria;
import com.example.takedelivery.model.Empresa;
import com.example.takedelivery.model.Produto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ClienteActivity extends AppCompatActivity {
    Empresa empresa = new Empresa("28.046.882/0001-45", "Delivery Menu", "8599568791", "60125151", "CE", "Fortaleza", "Dionisio Torres", "Osvaldo Cruz", "2085", Categoria.BRASILEIRA);
    ArrayList<Produto> cardapio = new ArrayList<Produto>();

    ArrayList<Empresa> empresas = new ArrayList<Empresa>();
    int selected;
    AdapterListViewEmpresas adapter;

    ListView listViewEmpresas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar );


        cardapio.add(new Produto("Vatapá de frango","Acompanha arroz branco e farofinha de mandioca. Vatapá de frando desfiado e finalizado com batata palha.", new BigDecimal(19.90)));
        cardapio.add(new Produto("Frango com salsa de ervas frescas","Acompanha arroz branco e purê de batatas. Filé de peito de frango em tiras adicnado de molho a base de azeite com ervas frescas.", new BigDecimal(19.90)));

        empresa.setCardapio(cardapio);
        empresas.add(empresa);
//        empresas.add(new Empresa("28.046.882/0001-45", "Delivery Menu", "8599568791", "60125151", "CE", "Fortaleza", "Dionisio Torres", "Osvaldo Cruz", "2085", Categoria.BRASILEIRA));

        selected = -1;
        adapter = new AdapterListViewEmpresas(empresas, this);

        listViewEmpresas = (ListView) findViewById(R.id.listViewRestaurantes);

        listViewEmpresas.setAdapter(adapter);
//        listViewEmpresas.setSelector(R.color.corSelect);


        listViewEmpresas.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {

                selected = position;
                verCardapio(arg1);
            }

        });



    }
    public void verCardapio (View view){
        Intent intent = new Intent(this, CardapioActivity.class);
        CardapioActivity.cardapio = empresa.getCardapio();
        intent.putExtra("nomeEmpresa", empresa.getNomeFantasia() );

        startActivity(intent);

    }


}