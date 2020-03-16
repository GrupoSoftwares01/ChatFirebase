package com.ramerips_cursos.erros;

//##Observação importante: Com dois cliques na tecla "SHIFT" temos um atalho para todos os arquivos da aplicação ##//

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ramerips_cursos.LoginActivity;
import com.ramerips_cursos.R;
import com.ramerips_cursos.RegistrarActivity;

public class ErroActivity extends AppCompatActivity {

    private TextView mtextView_LogarNovamente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_erro);

        mtextView_LogarNovamente = findViewById(R.id.idLogarNovamente);

        //Aqui será criado um evento de clique acionado pelo TextView "TextView_CriarConta" do layout "act_login"
        mtextView_LogarNovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui o objeto "objIntent" receberá uma nova "activity" para ser startada ou iniciada em um outro layout
                //que é a página "RegistrarActivity" que irá ser aberta pelo evento de clique
                Intent objIntent = new Intent(ErroActivity.this, LoginActivity.class);
                //Aqui será startada a activity "RegistrarActivity" recebida pelo objeto "intent"
                startActivity(objIntent);
            }
        });
    }
}
