package com.example.takedelivery;

import android.nfc.Tag;
import android.os.Bundle;

import com.example.takedelivery.adapter.AdapterListViewPersonalizada;
import com.example.takedelivery.model.Produto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CadastroProdutoActivity extends AppCompatActivity {

    int selected;
    ArrayList<Produto> cardapio;
    AdapterListViewPersonalizada adapter;

    ListView listViewProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        selected = -1;
        cardapio = new ArrayList<Produto>();
        cardapio.add(new Produto("Vatapá de frango","Acompanha arroz branco e farofinha de mandioca. Vatapá de frando desfiado e finalizado com batata palha.", new BigDecimal(19.90)));
        cardapio.add(new Produto("Frango com salsa de ervas frescas","Acompanha arroz branco e purê de batatas. Filé de peito de frango em tiras adicnado de molho a base de azeite com ervas frescas.", new BigDecimal(19.90)));

        adapter = new AdapterListViewPersonalizada(cardapio, this);
//        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cardapio);;//new AdapterListViewPersonalizada(cardapio, this);

        listViewProdutos = (ListView) findViewById(R.id.listViewProdutos);

//        listViewProdutos = (ListView) findViewById(R.id.listViewProdutos);


        listViewProdutos.setAdapter(adapter);
        listViewProdutos.setSelector(android.R.color.holo_blue_light);

        listViewProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                selected = position;
//                Produto item = adapter.getItem(position);
//                Log.d("myTag", item.toString());


            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_client, menu);

        return super.onCreateOptionsMenu(menu);
    }
}