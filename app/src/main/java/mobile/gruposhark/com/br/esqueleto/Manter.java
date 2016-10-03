
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


    public Manter(String texto, int contador) {
        this.texto = texto;
        this.contador = contador;
    }

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

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int _contador) {
        this.contador = _contador;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(texto);
        dest.writeInt(contador);
    }

    public int getSomarOnStartContador() {
        contador += 1000;
        return contador;
    }

    public int getAddOnResumeContador() {
        contador += 1;
        return contador;
    }

    public int getSubOnPauseContador() {
        contador -= 100;
        return contador;
    }
}
