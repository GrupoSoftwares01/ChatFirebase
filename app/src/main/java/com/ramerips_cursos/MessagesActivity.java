package com.ramerips_cursos;

//##Observação importante: Com dois cliques na tecla "SHIFT" temos um atalho para todos os arquivos da aplicação ##//

//<!--###- TECLAS DE ATALHOS PARA LOCALIZAR CLASSES OU ARQUIVOS.-###-->
//<!--##- Obs: CTRL+N -> Localiza uma "Classe", CTRL+SHIFT+N -> Localiza um "Arquivo" e CTRL+SHIFT+F -> Localiza um "Caminho" -##-->

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

//Aqui temos a classe "MessagesActivity" e que extende as funcionalidades da classe pai "AppCompatActivity"
public class MessagesActivity extends AppCompatActivity {

    //Aqui abaixo temos a implementação do método principal "onCreate()" da classe "MessagesActivity"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_messages);

        //Aqui será chamado o método "verifyAuthentication()" que verifica se o usuário já está logado ou não no Firebase
        verifyAuthentication();
    }

    //OBSERVAÇÂO: A primeira página a ser estartada é a "MessagesActivity", só se o usuário estiver logado, caso contrário
    //será a página "LoginActivity"

    //###Início do método que verifica se o usuário está logado junto ao Firebase ou não ###//
    //Este método verificará se o usuário está logado ou não junto ao "Firebase"
    private void verifyAuthentication(){
        //Aqui verifica se o usuário é nulo ou não...
        if(FirebaseAuth.getInstance().getUid() == null){
            //Aqui é criado um novo objeto "objIntent" do tipo "Intent" que receberá uma nova página ou layout
            //"LoginActivity" determinado pela "MessagesActivity", caso o usuário não esteja devidamente logado.
            Intent objIntent = new Intent(MessagesActivity.this, LoginActivity.class);
            //Aqui logo abaixo o objeto "objIntent" setará o método "setFlags()" que determina que a página
            //ou layout "MessagesActivity" seja ocultada ou encerrada e que fique em seu lugar a "LoginActivity"
            objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            //Aqui temos a inicialização do objIntent que é a activity "LoginActivity" por meio do método "startActivity()"
            startActivity(objIntent);
        }
    }
    //###Final do método que verifica se o usuário está logado junto ao Firebase ou não ###//


    //###Início do método que insere o menu na página ou layout, ou seja, trás o arquivo "menu.xml" para a página "MessagesActivity" ###//
    //Aqui será implementado o método "onCreateOptionsMenu()" que receberá como parâmetro a classe "Menu" e o
    //arquivo "menu.xml"
    public boolean onCreateOptionsMenu(Menu menu){
        //Aqui o método "getMenuInflater()", fará com que o arquivo de menu apareça ou seja acionado em determinada
        //pagina ou layoute mostrando assim suas opçoes para o usuário
        getMenuInflater().inflate(R.menu.menu, menu);
        //Aqui daremos "true" ou verdadeiro para o seu retorno
        return true;
    }
    //###Final do método que insere o menu na página, ou seja, trás o arquivo "menu.xml" para a página "MessagesActivity" ###//


    //###Início do método que escuta os eventos de clicks dos menus selecionados ###//
    //Aqui abaixo será implementado um método de escuta dos eventos de clique destes menus quando clicado
    public boolean onOptionsItemSelected(MenuItem item) {
        //Aqui abaixo será implementado com o "suitch(Escolha)" uma maneira de identifica qual foi o item ou "id" do menu que foi
        //clicado em uma das opções de menu existe neste "switch(Escolha)"
        switch (item.getItemId()) {
            //Aqui é informado que este item abaixo é o "id" contatos
            case R.id.idContatos:

                //Aqui é criado um novo objeto "objIntent" do tipo "Intent" que receberá uma nova página ou layout
                //"ContatosActivity" e determinada a sua abertura pela "MessagesActivity" caso o menu "idContatos" seja clicado
                Intent objIntent = new Intent(MessagesActivity.this, ContatosActivity.class);
                //Aqui logo abaixo o objeto "objIntent" setará o método "setFlags()" que determina que a página
                //ou layout a ser aberta seja a do objeto "objIntent" que é a "MessagesActivity"
                //->objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                //Aqui temos a inicialização da activity "MessagesActivity" por meio do método "startActivity()"
                startActivity(objIntent);

                //Aqui abaixo é dado um encerramento de escolha das opções deste "switch"
                break;


            //Aqui é informado que este item abaixo é o "id" sair
            case R.id.idSair:
                //Aqui abaixo será identificado qual é o usuário que está logado e irá deslogar este usuário com o método signOut()
                FirebaseAuth.getInstance().signOut();
                //Aqui abaixo com o método "verifyAuthentication()" será verificado se realmente o usuário não está logado
                verifyAuthentication();
                //Aqui abaixo é dado um encerramento de escolha das opções deste "switch"
                break;
        }
        //Aqui...
        return super.onOptionsItemSelected(item);
    }
    //###Final do método que escuta os eventos de clicks dos menus selecionados ###//
}
