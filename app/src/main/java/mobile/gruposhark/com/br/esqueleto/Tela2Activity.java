package mobile.gruposhark.com.br.esqueleto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela2Activity extends AppCompatActivity {

    private EditText editTextTela2;
    private Button buttonTela2Encerrar;
    private Button buttonVoltarTela2;

    private String texto;
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        editTextTela2 = (EditText)findViewById(R.id.editTextTela2);
        buttonTela2Encerrar = (Button)findViewById(R.id.buttonTela2Encerrar);
        buttonVoltarTela2 = (Button)findViewById(R.id.buttonVoltarTela2);

        Manter m =  getIntent().getExtras().getParcelable("_manter");

        texto = m.getTexto();
        contador = m.getContador();

        editTextTela2.setText(texto.concat("(" + String.valueOf(contador)) + ")");

    }

    @Override
    protected void onStart() {
        super.onStart();

        Manter m =  getIntent().getExtras().getParcelable("_manter");

        texto = "onStart";
        editTextTela2.setText(texto.concat("(" + m.getSomarOnStartContador()) + "),");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Manter m =  getIntent().getExtras().getParcelable("_manter");

        texto = "onResume";
        editTextTela2.setText(texto.concat("(" + m.getAddOnResumeContador()) + "),");    }

    @Override
    protected void onPause() {
        super.onPause();

        Manter m =  getIntent().getExtras().getParcelable("_manter");

        texto = "onPause";
        editTextTela2.setText(texto.concat("(" + m.getSubOnPauseContador()) + "),");

    }


    public void tela1Voltar_OnClick(View view){

        Manter manter = new Manter(texto, contador);
        Intent it = new Intent(this, Tela2Activity.class);
        it.putExtra("_manter", manter);
        startActivity(it);
    }

    public void encerrarTela2_OnClick(View view){
        finish();
    }

}
