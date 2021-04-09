import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.takedelivery.R;

public class Escolha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha);

    }

    public void abrirAcessoCliente(View view){
        Intent i  = new Intent(Escolha.this, AcessoCliente.class);
        startActivity(i);
        finish();
    }
    public void abrirAcessoEmpresa(View view){
        Intent j  = new Intent(Escolha.this, AcessoEmpresa.class);
        startActivity(j);
        finish();
    }


}