package mobile.gruposhark.com.br.esqueleto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela2Activity extends Activity {

    private EditText editTextTela2;
    private Button buttonTela2Encerrar;
    private Button buttonVoltarTela2;

    Manter manter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        Log.e("Tela 2 -> ", "onCreate");

        editTextTela2 = (EditText)findViewById(R.id.editTextTela2);
        buttonTela2Encerrar = (Button)findViewById(R.id.buttonTela2Encerrar);
        buttonVoltarTela2 = (Button)findViewById(R.id.buttonVoltarTela2);

        manter =  getIntent().getExtras().getParcelable("_manter");
        //manter.setQuem("onCreate");
        //manter.setTela("2");
        editTextTela2.setText(manter.getTexto());

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Tela 2 -> ", "onStart");

        //manter.somarOnStartContador();
        // manter =  getIntent().getExtras().getParcelable("_manter");
        //editTextTela2.setText( manter.getTexto() );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Tela 2 -> ", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Tela 2 -> ", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Tela 2 -> ", "onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.e("Tela 2 -> ", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Tela 2 -> ", "onDestroy");
    }

    public void tela1Voltar_OnClick(View view){
        onBackPressed();

        //Intent it = new Intent(this, MainActivity.class);
        //it.putExtra("_manter", manter);
        //startActivity(it);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
    public void encerrarTela2_OnClick(View view){
        finish();
    }

}
