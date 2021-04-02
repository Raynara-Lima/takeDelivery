package com.example.takedelivery;

import android.os.Bundle;

import com.example.takedelivery.adapter.AdapterListViewPedidos;
import com.example.takedelivery.model.Pedido;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PedidosEmpresaActivity extends AppCompatActivity {
    public static ArrayList<Pedido> pedidos;
    int selected;
    AdapterListViewPedidos adapter;

    ListView listViewPedidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos_empresa);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
//        ViewPager pager = (ViewPager) findViewById(R.id.pager);
//        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
//
//        pager.setAdapter(adapter);
//        tabs.setupWithViewPager(pager);

        pedidos = new ArrayList<Pedido>();

        pedidos.add(new Pedido("Raynara Silva Lima", "25/02", "11:05", "Rua Crispim Almeida", "1415", "Mastercard credido"));
        pedidos.add(new Pedido("Raynara Silva Lima", "25/02", "11:05", "Rua Crispim Almeida", "1415", "Mastercard credido"));

        selected = -1;

        adapter = new AdapterListViewPedidos(pedidos, this);

        listViewPedidos = (ListView) findViewById(R.id.listViewPedidos);

        listViewPedidos.setAdapter(adapter);
        listViewPedidos.setSelector(R.color.corSelect);


        listViewPedidos.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {

                selected = position;
            }

        });
    }
}