package com.example.takedelivery;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class Client extends AppCompatActivity {

private MaterialSearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        inicializar();
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Client");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_client, menu);

        MenuItem item = menu.findItem(R.id.menuSearch);
        searchView.setMenuItem(item);

        SearchView searchView = (SearchView) item.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case R.id.menugetOut :
                sair();
                break;
            case R.id.menuSet :
                definir();
                break;
            default:
                Intent myIntent = new Intent(getApplicationContext(), Choose.class);
                startActivityForResult(myIntent, 0);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
    private void inicializar(){
        searchView = findViewById(R.id.materialSearchView);
    }

    private void sair() {
      finish();
    }


    private void definir(){

    }

}