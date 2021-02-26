package com.example.takedelivery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.takedelivery.R;
import com.example.takedelivery.model.Pedido;
import com.example.takedelivery.model.Produto;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class AdapterListViewPedidos extends BaseAdapter {

    private final List<Pedido> pedidos;
    private final Context c;

    public AdapterListViewPedidos(List<Pedido> pedidos, Context context) {
        this.pedidos = pedidos;
        this.c = context;
        ;
    }

    @Override
    public int getCount() {
        return pedidos.size();
    }

    @Override
    public Pedido getItem(int position) {
        return pedidos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(c).inflate(R.layout.layout_list_pedidos, parent, false);
        Pedido pedido = pedidos.get(position);

        TextView idPedido = (TextView) convertView.findViewById(R.id.textViewIdPedido);
        TextView data = (TextView) convertView.findViewById(R.id.textViewData);
        TextView nomeCliente = (TextView) convertView.findViewById(R.id.textViewNomeCliente);

        idPedido.setText( String.valueOf(pedido.getId()));
        data.setText(pedido.getData());
        nomeCliente.setText(pedido.getNomeCliente());

//        convertView.findViewById(R.id.cardView).setOnClickListener((v) ->{
//                            Log.e("DEBUG", "teste");
//
//            Toast.makeText(c, produto.getNome(), Toast.LENGTH_SHORT).show();
//            });
//        view.findViewById(R.id.cardView).setOnClickListener(){
//
//        }
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //CARREGA REGISTRO DE ACORDO COM O ITEM SELECIONADO
//                int indice = produto.getId();
//                //new Inicio().carregaCadastro(indice); FAIL - FORCE CLOSE
//                //Inicio in = new Inicio().carregaCadastro(indice); - FAIL - FORCE CLOSE
//                //in.carregaCadastro(indice); - FAIL - FORCE CLOSE
////                carregaCadastro(indice);//MÉTODO NÃO ENCONTRADO
//            }
//        });
        return convertView;

    }
}