package com.example.maurolcsilva.lanchonete;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Janela extends Activity {
    //Criação dos componentes em Java
    private Spinner spFrutas;
    private RadioGroup rgTipo;
    private CheckBox chkBolo;
    private CheckBox chkSalgado;
    private CheckBox chkBiscoito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_janela);
        //Recuperação dos componentes a partir do arquivo de layout
        spFrutas = (Spinner) findViewById(R.id.spFrutas);
        rgTipo = (RadioGroup) findViewById(R.id.rdgTipo);
        chkBiscoito = (CheckBox) findViewById(R.id.chkBiscoito);
        chkBolo = (CheckBox) findViewById(R.id.chkBolo);
        chkSalgado = (CheckBox) findViewById(R.id.chkSalgado);
    }

    public void MostraDados(View v){
        String fruta,tipo="",acompanhamentos="";

        //Recuperação do item selecionado do spinner
        //Como é recuperado um objeto deve-se fazer um toString para
        //recuperamos um String
        fruta = spFrutas.getSelectedItem().toString();
        Toast.makeText(this,fruta,Toast.LENGTH_SHORT).show();
        //Recuperamos a partir do RadioGroup o radiobutton
        //que foi selecionado. Poderiamos também usar
        //o método isChecked()
        int id = rgTipo.getCheckedRadioButtonId();
        switch (id){
            //Temos de comparar o id recuperado com o id dos radiobuttons
            case (R.id.rdGelado):
                tipo = "Gelado";
                break;
            case (R.id.rdNatural):
                tipo = "Natural";
                break;
        }
        Toast.makeText(this,tipo,Toast.LENGTH_SHORT).show();
        //Verificando se o checkbox esta selecionado ou não
        //Caso tenha sido selecionado ele retorna True
        //Caso constrário, retorna False
        if (chkBolo.isChecked()){
            acompanhamentos = " Bolo ";
        }

        if (chkSalgado.isChecked()){
            acompanhamentos = acompanhamentos + " Salgado ";
        }

        if (chkBiscoito.isChecked()){
            acompanhamentos = acompanhamentos + " Biscoito ";
        }
        Toast.makeText(this,acompanhamentos,Toast.LENGTH_SHORT).show();
    }
}
