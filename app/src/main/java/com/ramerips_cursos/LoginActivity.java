package com.ramerips_cursos;

//##Observação importante: Com dois cliques na tecla "SHIFT" temos um atalho para todos os arquivos da aplicação ##//

//<!--###- TECLAS DE ATALHOS PARA LOCALIZAR CLASSES OU ARQUIVOS.-###-->
//<!--##- Obs: CTRL+N -> Localiza uma "Classe", CTRL+SHIFT+N -> Localiza um "Arquivo" e CTRL+SHIFT+F -> Localiza um "Caminho" -##-->

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.ramerips_cursos.erros.ErroActivity;

import static android.widget.Toast.LENGTH_LONG;

public class LoginActivity extends AppCompatActivity {

    //Aqui serão criados os atributos relacionados aos campos do layout "act_login"
    private EditText mEditText_Email;
    private EditText mEditText_Senha;
    private Button mBtn_Entrar;
    private TextView mtextView_CriarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);

        //Aqui serão recuperados os dados inseridos nos campos do layout ou página "act_login"
        mEditText_Email = findViewById(R.id.editText_Email);
        mEditText_Senha = findViewById(R.id.editText_Senha);
        mBtn_Entrar = findViewById(R.id.btn_Cadastrar);
        mtextView_CriarConta = findViewById(R.id.textView_CriarConta);


        //### Aqui abaixo temos o início da ação do evento de click da função ou método "onClick()" ###//
        //Aqui será criado um evento de clique acionado pelo botão "btn_Entrar" do layout "act_login.xml"
        mBtn_Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui abaixo serão criadas as variáveis do tipo string(email e senha), que receberão os valores contidos nos dados recuperados
                //logo acima, por meio do método "getText()" e transformados em string por meio do método "toString()"
                String email = mEditText_Email.getText().toString();
                String senha = mEditText_Senha.getText().toString();

                //Aqui abaixo serão impressas as variáveis por meio do "Log.i" e as strings "Teste" que as antecede -> (Aqui é teste do desenvolvedor)
                //->Log.i("Teste", email);
                //->Log.i("Teste", senha);

                //Aqui será verificado se os campos do formulário do email e senha estão inválidos ou nulos(Vazios), onde a mensagem do "Toast"
                //só será impressa para o usuário caso estejam com problemas "Inválidos ou vazios".
                if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
                    //Aqui será implementado um estilo de mensagem volátil do tipo "Toast" que será exibida ao usuário, onde existe a possibilidade de
                    //ser do tipo "Toast.LENGTH_LONG(Longa duração) e Toast.LENGTH_SHORT(Rápida duração)", onde desaparece automaticamente.
                    Toast.makeText(LoginActivity.this, "E-mail ou senha devem ser preenchidos corretamente", LENGTH_LONG).show();
                    //Aqui temos o retorno de toda a contextualização desta função
                    return;
                }

                //Aqui abaixo é o evento que escutará o sucesso da execução da tarefa caso insira um novo usuário
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                //Aqui abaixo temos uma mensagem "Teste" em modo "Log.i" com a impressão da "usuário" em formato de string
                                //que é mostada ao desenvolvedor no painel do "6: Logcat" com o link de acesso da mesma
                                Log.i("Teste", task.getResult().getUser().getUid());

                                //Aqui é criado um novo objeto "objIntent" do tipo "Intent" que receberá uma nova página ou layout
                                //"MessagesActivity" e determinada a sua abertura pela "LoginActivity"
                                Intent objIntent = new Intent(LoginActivity.this, MessagesActivity.class);
                                //Aqui logo abaixo o objeto "objIntent" setará o método "setFlags()" que determina que a página
                                //ou layout a ser aberta seja a do objeto "objIntent" que é a "MessagesActivity"
                                objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                //Aqui temos a inicialização da activity "MessagesActivity" por meio do método "startActivity()"
                                startActivity(objIntent);
                            }
                        })
                        //Aqui abaixo é o evento que escutará o erro da execução da tarefa, caso não insira um novo usuário
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //Aqui abaixo temos uma mensagem "Teste" em modo "Log.i" com a impressão da "usuário" em formato de string
                                //que é mostada ao desenvolvedor no painel do "6: Logcat" com o link de acesso da mesma
                                Log.i("Teste", e.getMessage());
                            }
                        });
                }
        });
        //### Aqui abaixo temos o final da ação do evento de click da função ou método "onClick()" ###//


        //### Aqui abaixo temos o início da ação do evento de click da função ou método "onClick()" ###//
        //Aqui será criado um evento de clique acionado pelo TextView "TextView_CriarConta" do layout "act_login.xml"
        mtextView_CriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            //Aqui temos a função ou método de evento de click "onClick"
            public void onClick(View v) {
                //Aqui o objeto "objIntent" receberá uma nova "activity" para ser startada ou iniciada em um outro layout
                //que é a página "RegistrarActivity" que irá ser aberta pelo evento de clique
                Intent objIntent = new Intent(LoginActivity.this, RegistrarActivity.class);
                //Aqui será startada a activity "RegistrarActivity" recebida pelo objeto "objIntent"
                startActivity(objIntent);
            }
        });
        //### Aqui abaixo temos o final da ação do evento de click da função ou método "onClick()" ###//
    }
}
