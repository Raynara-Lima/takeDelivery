package com.example.takedelivery;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.example.takedelivery.adapter.AdapterListViewPersonalizada;

import com.example.takedelivery.model.Produto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CardapioEmpresaActivity extends AppCompatActivity {

    public static ArrayList<Produto> cardapio;
    int selected;
    AdapterListViewPersonalizada adapter;

    ListView listViewProdutos;
    BancoDeDados bancoDeDados;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance ();
    private DatabaseReference mDatabaseReference = mDatabase.getReference ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDatabaseReference.child("produtos").addValueEventListener(new ValueEventListener() {
            @Override//                activity.updateCardapio( cardapio );

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String value = dataSnapshot.getValue(String.class);
                cardapio.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    cardapio.add(ds.getValue(Produto.class));
                    Log.d(  "firebase", "Value is: " + ds.getValue(Produto.class));

                }
                montarListView();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        cardapio = CardapioEmpresaActivity.cardapio;
//        CardapioActivity.cardapio = null;
//        cardapio = new ArrayList<Produto>();
//        cardapio.add(new Produto("Vatapá de frango","Acompanha arroz branco e farofinha de mandioca. Vatapá de frando desfiado e finalizado com batata palha.", new BigDecimal(19.90)));
//        cardapio.add(new Produto("Frango com salsa de ervas frescas","Acompanha arroz branco e purê de batatas. Filé de peito de frango em tiras adicnado de molho a base de azeite com ervas frescas.", new BigDecimal(19.90)));
//
//

        selected = -1;
//        cardapio = new ArrayList<Produto>();
//        cardapio.add(new Produto("Vatapá de frango","Acompanha arroz branco e farofinha de mandioca. Vatapá de frando desfiado e finalizado com batata palha.", new BigDecimal(19.90)));
//        cardapio.add(new Produto("Frango com salsa de ervas frescas","Acompanha arroz branco e purê de batatas. Filé de peito de frango em tiras adicnado de molho a base de azeite com ervas frescas.", new BigDecimal(19.90)));


    }
    public void montarListView(){
        adapter = new AdapterListViewPersonalizada(cardapio, this);

        listViewProdutos = (ListView) findViewById(R.id.listViewProdutos);

        listViewProdutos.setAdapter(adapter);
        listViewProdutos.setSelector(R.color.corSelect);

//        bancoDeDados = new BancoDeDados( this, listViewProdutos );
//        bancoDeDados.start();

        listViewProdutos.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {

                selected = position;
            }

        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cardapio, menu);

        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected( MenuItem item ) {

        switch(item.getItemId())
        {
            case R.id.adicionar:
                adicionarProduto();
                break;
            case R.id.editar:
                editarProduto();
                break;
            case R.id.excluir:
                excluirProduto();
                break;

        }
        return true;
    }

    public void adicionarProduto(){
        Intent intent = new Intent( this, CadastroProdutoActivity.class );
        int idNovoProduto;
        if(cardapio.isEmpty()){
            idNovoProduto = 0;
        }else {
            idNovoProduto = cardapio.get(cardapio.size() - 1).getId() + 1;
        }
        intent.putExtra( "id", idNovoProduto );



        startActivityForResult( intent, Constants.REQUEST_ADD );
    }
    public void editarProduto(){
        Intent intent = new Intent( this, CadastroProdutoActivity.class );
        Produto produto = cardapio.get(selected);

        intent.putExtra( "idEdit", produto.getId() );
        intent.putExtra( "nome", produto.getNome() );
        intent.putExtra( "descricao", produto.getDescricao() );
        intent.putExtra( "preco", produto.getPreco() );

        startActivityForResult( intent, Constants.REQUEST_EDIT );
    }
    public void excluirProduto(){
       mDatabase.getReference ().child ("produtos").child( String.valueOf(cardapio.get( selected ).getId())).removeValue();

        if( cardapio.size() > 0 ){
            cardapio.remove( selected );
            adapter.notifyDataSetChanged();;
        } else {
            selected = -1;
        }

    }

    public void updateCardapio( ArrayList<Produto> lista ){
//        progressBar.setVisibility( View.INVISIBLE );

//        Produto[] lista = cardapio;
        cardapio.clear();
        cardapio.addAll(lista);

        adapter.notifyDataSetChanged();;
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data ) {
        super.onActivityResult(requestCode, resultCode, data);
//
//        if( requestCode == Constants.REQUEST_ADD && resultCode == Constants.RESULT_ADD ){
//            String nome = ( String )data.getExtras().get("nome");
//            String descricao = ( String )data.getExtras().get("descricao");
//            String preco = (String) data.getExtras().get("preco");
//            Produto produto = new Produto( nome, descricao, new Float(preco ));
//            cardapio.add( produto );
//
//            adapter.notifyDataSetChanged();
//
//        }else if( requestCode == Constants.REQUEST_EDIT && resultCode == Constants.RESULT_ADD ){
//            String nome = ( String )data.getExtras().get("nome");
//            String descricao = ( String )data.getExtras().get("descricao");
//            String preco = (String) data.getExtras().get("preco");
//            int idEdit = (int)data.getExtras().get( "id" );
//
//            for( Produto produto: cardapio ){
//                if( produto.getId() == idEdit ){
//                    produto.setNome(nome);
//                    produto.setDescricao(descricao);
//                    produto.setPreco(new Float(preco));
//                }
//            }
//            adapter.notifyDataSetChanged();
//        } else
        if( resultCode == Constants.RESULT_CANCEL ){
            Toast.makeText( this,"Cancelado",
                    Toast.LENGTH_SHORT).show();
        }

    }
}

