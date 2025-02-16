package com.github.lucasdevrj.cadastrodeshinobi.missao;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository é uma abstração ao um banco de dados
//Com ele podemos realizar funções de forma mais fácil e pratica, como por exemplo salvar informações no banco de dados
//Quando extendemos um JPA precisamos passar os parâmetros: Classe e o tipo de dado do ID da classe
//Ele facilita no sentido do programador não precisar criar queryes SQL para acessar informações do Banco de Dados
//Ele acompanha as alterações da Classe, então segue os mesmos dados da Classe na sua tabela (ORM)
//Possui vários métodos padrões de interação com o Banco de Dados
public interface MissaoRepository extends JpaRepository<MissaoModel, Long> {
}
