package mobile.gruposhark.com.br.esqueleto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Manter manter;;   // Compartilhar entre os objetos

    private String texto;
    private int contador;

    //String texto;   //
    private EditText editTextTela1;
    private Button buttonTela1Encerrar;
    private Button buttonIrTela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTela1 = (EditText) findViewById(R.id.editTextTela1);
        buttonTela1Encerrar = (Button) findViewById(R.id.buttonTela1Encerrar);
        buttonIrTela2 = (Button) findViewById(R.id.buttonIrTela2);

        texto = "onCreate";
        contador = contador + 0;
        editTextTela1.setText(texto.concat("(" + String.valueOf(contador)) + "),");

    }

    public void tela2_OnClick(View view){

        Manter manter = new Manter(texto, contador);
        Intent it = new Intent(this, Tela2Activity.class);
        it.putExtra("_manter", manter);
        startActivity(it);
}

    public void encerrar_OnClick(View view){

        finish();
    }
}
