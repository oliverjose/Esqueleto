package mobile.gruposhark.com.br.esqueleto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        Log.e("Tela 1 -> ", "onCreate");

        manter = new Manter();
        manter.setQuem("onCreate");
        manter.setTela("1");

        editTextTela1 = (EditText) findViewById(R.id.editTextTela1);
        buttonTela1Encerrar = (Button) findViewById(R.id.buttonTela1Encerrar);
        buttonIrTela2 = (Button) findViewById(R.id.buttonIrTela2);

        //editTextTela1.setText(manter.getTexto());
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Tela 1 -> ", "onStart");

        manter.setQuem("onStart");
        manter.setTela("1");

        manter.somarOnStartContador();
        //editTextTela1.setText(manter.getTexto());

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Tela 1 -> ", "onResume");
        manter.setQuem("onResume");
        manter.setTela("1");
        manter.somarOnResumeContador();
        editTextTela1.setText(manter.getTexto());
      }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Tela 1 -> ", "onPause");
        manter.setQuem("onPause");
        manter.setTela("1");
        manter.subtrairOnPauseContador();
        //editTextTela1.setText(manter.getTexto());
      }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Tela 1 -> ", "onStop");
        manter.setQuem("onStop");
        manter.setTela("1");
        manter.somarOnStopContador();

         }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.e("Tela 1 -> ", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Tela 1 -> ", "onDestroy");
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
