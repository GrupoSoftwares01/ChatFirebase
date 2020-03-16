package com.ramerips_cursos;

//##Observação importante: Com dois cliques na tecla "SHIFT" temos um atalho para todos os arquivos da aplicação ##//

//Aqui temos a implementação da classe usuário "User"
public class User {

    //Aqui teremos os atributos ou variáveis necessárias para a aplicação
    //Aqui abaixo temos o id "uuid" identificador de um determinado usuário
    private String uuid;
    //Aqui abaixo temos o nome "username" pertencente a determinado usuário
    private String username;
    //Aqui abaixo temos o identificador "profileUrl" da imagem pertencente a cada usuário
    private String profileUrl;

    //Aqui temos um construtor padrão para viabilizar a execução
    public User(){

    }

    //Aqui nós temos os atributos recebendo os valores de seus parâmetro do método abaixo
    public User(String uuid, String username, String profileUrl) {
        this.uuid = uuid;
        this.username = username;
        this.profileUrl = profileUrl;
    }

    //Aqui temos os "Gets e Sets" da classe "User"
    public String getUuid() {
        return uuid;
    }
    public String getUsername() {
        return username;
    }
    public String getProfileUrl() {
        return profileUrl;
    }
}
