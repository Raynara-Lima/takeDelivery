package com.example.takedelivery.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.takedelivery.R;
import com.example.takedelivery.model.Produto;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class AdapterListViewPersonalizada extends BaseAdapter {

    private final List<Produto> produtos;
    private final Activity act;

    public AdapterListViewPersonalizada(List<Produto> produtos, Activity act) {
        this.produtos = produtos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Produto getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.content_cadastro_produto, parent, false);
        Produto produto = produtos.get(position);

        TextView nome = (TextView) view.findViewById(R.id.lista_produtos_personalizada_nome);
        TextView descricao = (TextView) view.findViewById(R.id.lista_produtos_personalizada_descricao);
        TextView preco =  (TextView) view.findViewById(R.id.lista_produtos_personalizada_preco);

        nome.setText(produto.getNome());
        descricao.setText(produto.getDescricao());
        Locale ptBr = new Locale("pt", "BR");
        preco.setText( NumberFormat.getCurrencyInstance(ptBr).format(produto.getPreco()));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CARREGA REGISTRO DE ACORDO COM O ITEM SELECIONADO
                int indice = produto.getId();
                //new Inicio().carregaCadastro(indice); FAIL - FORCE CLOSE
                //Inicio in = new Inicio().carregaCadastro(indice); - FAIL - FORCE CLOSE
                //in.carregaCadastro(indice); - FAIL - FORCE CLOSE
//                carregaCadastro(indice);//MÉTODO NÃO ENCONTRADO
            }
        });
        return view;

    }

}