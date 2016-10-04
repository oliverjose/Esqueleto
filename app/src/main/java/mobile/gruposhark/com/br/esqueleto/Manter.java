
package mobile.gruposhark.com.br.esqueleto;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by jose.oliveira on 30/09/2016.
 *
 * Com base no exemplo: http://pt.stackoverflow.com/questions/38492/quando-e-como-implementar-o-parcelable-vs-serializable
 *
 */
public class Manter implements Parcelable {

    private String texto;
    private int contador;
    private String quem;
    private String tela;

    public Manter()
    {
        contador = 0;
        texto =  "";
    }

    public void setTela(String _tela){
        tela = _tela;
    }

    public void setQuem(String _quem)
    {
        quem = _quem;
        //concatenar();

    }
    //public Manter(String texto, int contador) {
    //    this.texto = texto;
    //    this.contador = contador;
    //}

    private Manter(Parcel from){
        texto = from.readString();
        contador = from.readInt();
    }

    public static final Parcelable.Creator<Manter>
            CREATOR = new Parcelable.Creator<Manter>(){

        @Override
        public Manter createFromParcel(Parcel in) {
            return new Manter(in);
        }

        @Override
        public Manter[] newArray(int size) {
            return new Manter[size];
        }
    };

    public String getTexto() {

        return texto;
    }

    // public void setTexto(String texto) {
    //;;    this.texto = texto;
    //}

    //public int getContador() {
    //    return contador;
    //}

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(texto);
        dest.writeInt(contador);
    }

    public void addOnCreateContador(){
        contador = 0;
        concatenar();
        return;
    }

    public void somarOnStartContador() {
        contador += 1000;
        concatenar();
        return;
    }

    public void somarOnResumeContador() {
        contador += 1;
        concatenar();
        return;
    }

    public void subtrairOnPauseContador() {
        contador -= 100;
        concatenar();
        return;
    }

    public void somarOnStopContador() {
        contador -= 550;
        concatenar();
        return;
    }

    private void concatenar()
    {
        // texto = texto.concat("Tela("+ tela + "), Método(" + quem  + "), Contador[" + contador + "] | ");
        texto += "Tela("+ tela + "), Método(" + quem  + "), Contador[" + contador + "] | ";
    }
}
