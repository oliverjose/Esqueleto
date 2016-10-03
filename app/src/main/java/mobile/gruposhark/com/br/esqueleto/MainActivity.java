package mobile.gruposhark.com.br.esqueleto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Manter manter;   // Compartilhar entre os objetos

    private EditText editTextTela1;
    private Button buttonTela1Encerrar;
    private Button buttonIrTela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manter = new Manter();
        manter.setQuem("Main");

        editTextTela1 = (EditText) findViewById(R.id.editTextTela1);
        buttonTela1Encerrar = (Button) findViewById(R.id.buttonTela1Encerrar);
        buttonIrTela2 = (Button) findViewById(R.id.buttonIrTela2);

        editTextTela1.setText(manter.getTexto());

    }

    @Override
    protected void onResume() {
        super.onResume();

        manter.somarOnResumeContador();
        // manter =  getIntent().getExtras().getParcelable("_manter");
        editTextTela1.setText( manter.getTexto() );
    }


    @Override
    protected void onPause() {
        super.onPause();

        manter.subtrairOnPauseContador();
        // manter =  getIntent().getExtras().getParcelable("_manter");
        editTextTela1.setText( manter.getTexto() );

    }

    @Override
    protected void onStop() {
        super.onStop();
        manter.somarOnStopContador();
        // manter =  getIntent().getExtras().getParcelable("_manter");
        editTextTela1.setText( manter.getTexto() );
    }

    public void tela2_OnClick(View view){

        // Intent it = new Intent(MainActivity.this, Tela2Activity.class);
        Intent it = new Intent(this, Tela2Activity.class);
        it.putExtra("_manter", manter);
        startActivity(it);
}

    public void encerrar_OnClick(View view){

        finish();
    }
}
