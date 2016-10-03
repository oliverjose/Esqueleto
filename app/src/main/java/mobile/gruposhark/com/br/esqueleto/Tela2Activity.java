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

    Manter manter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        editTextTela2 = (EditText)findViewById(R.id.editTextTela2);
        buttonTela2Encerrar = (Button)findViewById(R.id.buttonTela2Encerrar);
        buttonVoltarTela2 = (Button)findViewById(R.id.buttonVoltarTela2);

        manter =  getIntent().getExtras().getParcelable("_manter");
        manter.setQuem("Tela2");


        editTextTela2.setText(manter.getTexto());
    }

    @Override
    protected void onStart() {
        super.onStart();

        manter.somarOnStartContador();
        // manter =  getIntent().getExtras().getParcelable("_manter");

        editTextTela2.setText( manter.getTexto() );
    }

    public void tela1Voltar_OnClick(View view){

        Intent it = new Intent(this, MainActivity.class);
        //it.putExtra("_manter", manter);
        startActivity(it);
    }

    public void encerrarTela2_OnClick(View view){
        finish();
    }

}
