package com.ramerips_cursos;

//##Observação importante: Com dois cliques na tecla "SHIFT" temos um atalho para todos os arquivos da aplicação ##//

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.GroupieViewHolder;
import com.xwray.groupie.Item;

import java.util.List;

import javax.annotation.Nullable;

//Aqui abaixo temos a classe "ContatosActivity" que estende as funcionalidades e atributos da classe pai "AppCompatActivity"
public class ContatosActivity extends AppCompatActivity {

    //Aqui abaixo está sendo criado um objeto "objAdapter" do tipo "GroupAdapter"
    private GroupAdapter objAdapter;

    //Aqui abaixo temos a implementação do método principla "onCreate" da classe "ContatosActivity"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_contatos);

        //Aqui a variável-objeto "objRecyclerView" receberá todos os usuários constante na lista do "idRecyclerViewContatos"
        RecyclerView objRecyclerView = findViewById(R.id.idRecyclerViewContatos);
        //Aqui abaixo o objeto "objRecyclerView" setará o método "setAdapter()" explorando o seu parâmetro "objAdapter"
        objRecyclerView.setAdapter(objAdapter);

        //Aqui abaixo está sendo inicializado um novo objeto "objAdapter" do tipo "GroupAdapter"
        objAdapter = new GroupAdapter();

        //Obs: Fetch -> Buscar, Users -> Usuários ou seja (FetchUsers -> Buscar Usuários)
        //Aqui é chamado o método "fetchUsers()", responsável por resgatar ou buscar os usuário no "Firebase"
        fetchUsers();
    }

    //Obs: Fetch -> Buscar, Users -> Usuários ou seja (FetchUsers -> Buscar Usuários)

    //###Início do método que irá buscar o usuário no Firebase ###//
    //Este método será o responsável por resgatar ou buscar o usuário requisitado no "Firebase"
    private void fetchUsers(){
        //Aqui é verificado, encontrado e buscado junto ao "Firebase" a coleção "users" e seus conteúdos
        FirebaseFirestore.getInstance().collection("/users")
                //Aqui é adicionado instantaneamente em uma lista por meio do método "EventListener<QuerySnapshot>()"
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    //Aqui abaixo é um evento de escuta da execução da atividade ocorrida por meio do método "onEvent()" e seus parâmetros
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        //Aqui abaixo será verificado se há ou não exceção(Erros) -> "e" for diferente de nulo
                        if(e != null){
                            //Aqui abaixo temos uma mensagem "Teste" em modo "Log.e" com a impressão do conteúdo de erro
                            //que é mostada ao desenvolvedor no painel do "6: Logcat"
                            //->Log.e("Teste", e.getMessage(), e);
                            //Aqui temos o retorno da execução em questão
                            return;
                        }
                            //Aqui temos o objeto "objDocuments" do tipo "List<DocumentSnapshot>" que receberá todos os dados ou conteúdos
                            //de documentos contidos dentro da consulta instantânia "queryDocumentSnapshots" e que é trazida pelo método
                            //"getDocuments()", onde consta cada elemento ou usuário trazido pelo mesmo
                            List<DocumentSnapshot> objDocuments = queryDocumentSnapshots.getDocuments();

                            //Aqui temos a implementação de um "for" que percorrerá todos os usuários existentes neste objeto "objDocConteudo"
                            //que está dentro do Firebase
                            for(DocumentSnapshot objDocConteudo : objDocuments){
                                //Aqui abaixo temos a criação de um objeto "user" que guardará ou receberá todos os usuários existentes no Firebase
                                User user = objDocConteudo.toObject(User.class);
                                //Aqui abaixo temos uma mensagem do tipo string "Teste" em modo "Log.d" com a impressão dos usuários cadastrados do Firebase
                                //que é mostada ao desenvolvedor por meio do painel console do "6:Logcat"
                                //->Log.d("Teste", user.getUsername());
                            }
                    }
                });
    }
    //###Final do método que irá buscar o usuário no Firebase ###//

    /*
    //Aqui abaixo temos a implementação de uma classe interna que gerenciará cada item interno a esta classe
    //private class UserItem extends Item<ViewHolder> {
    private class UserItem extends Item {

        //Aqui abaixo é criado um objeto "user" da classe "User"
        private final User user;
        //Aqui abaixo é criado um construtor para poder pegar o usuário
        private UserItem(User user) {
            this.user = user;
        }

        @Override
        public void bind(@NonNull GroupieViewHolder viewHolder, int position) {
            //
            TextView txtNomeUsuario = viewHolder.itemView.findViewById(R.id.idTextViewUsuario);
            ImageView imagemFoto = viewHolder.itemView.findViewById(R.id.idImagemAvatar);

            //
            txtNomeUsuario.setText(user.getUsername());

            //Aqui abaixo pegamos a classe "Picasso" que setará o método "get()" de buscar ou trazer
            Picasso.get()
                    //Aqui abaixo temos o carregamento da foto pelo objeto "user" e o método "getProfileUrl()"
                    .load(user.getProfileUrl())
                    .into(imagemFoto);
        }

        @Override
        public int getLayout() {
            return R.layout.item_user;
        }
    }
    */
}
