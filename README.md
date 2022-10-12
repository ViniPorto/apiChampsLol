<p align="center">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/viniporto/apiChampsLol?color=%2304D361">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/viniporto/apiChampsLol">
  
  <a href="https://github.com/viniporto/apiChampsLol/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/viniporto/apiChampsLol">
  </a>
    
   <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen">
   <a href="https://github.com/viniporto/apiChampsLol/stargazers">
    <img alt="Stargazers" src="https://img.shields.io/github/stars/viniporto/apiChampsLol?style=social">
  </a>

  <a href="https://www.linkedin.com/in/vinicius-porto-9a1996209/">
    <img alt="Feito por Vinícius Porto" src="https://img.shields.io/badge/feito%20por-Vinicius Porto-%237519C1">
  </a> 
 
</p>
<h1 align="center">
    apiChampsLol
</h1>

<h4 align="center"> 
	🚧  apiChampsLol 👾 Concluído 🚀 🚧
</h4>

## 💻 Sobre o projeto

👾 apiChampsLol - é uma API feita para complementar o projeto do repositório <a href="https://github.com/mirellanaspolini/clone-league-of-legends">Clone league of legends</a>.

Projeto desenvolvido com a a inteção de iniciar os estudos na área de API's com Java. Portanto não há verificação em validação, segurança, etc.

---

## ⚙️ Funcionalidades

- [x] Qualquer um pode consultar informações sobre os campeões do League Of Legends utilizando filtros de:
  - [x] nome do campeão
  - [x] role do campeão (assassino, suporte, lutador, tank, mago e atirador)
  - [x] além de escolher o método de ordenação, que pode ser: 
    - ordem de lançamento ↑ ↓
    - ordem alfabética ↑ ↓
    - preço RP ↑ ↓
    - preço EA ↑ ↓
   
- [ ] Criar, editar ou deletar as informações de um campeão
  - Esta função está documentada no projeto, porém está desativada no servidor onde está rodando, para previnir vandalismo hehe :D

---

## 🚀 Como executar o projeto

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Maven](https://maven.apache.org/download.cgi), [JDK](https://www.oracle.com/br/java/technologies/downloads/). 
Além disto é bom ter um editor para trabalhar com o código como [VSCode](https://code.visualstudio.com/). Também é preciso se registrar no [MongoDB](https://www.mongodb.com/cloud/atlas/lp/try4?utm_source=google&utm_campaign=search_gs_pl_evergreen_atlas_core_prosp-brand_gic-null_amers-br_ps-all_desktop_eng_lead&utm_term=mongodb&utm_medium=cpc_paid_search&utm_ad=e&utm_ad_campaign_id=12212624308&adgroup=115749706023&gclid=Cj0KCQjwy5maBhDdARIsAMxrkw16DM1DQMlG7vLVelBgSJCAUXzCCJdkZeOzsd7WaHFkLCtETmWO_AkaAtVSEALw_wcB) e criar um database para pegar a string de conexão com o banco.

#### 🟢 Criando o database no MongoDB
- Registre-se no mongoDB;
- Browse connections;
![image](https://user-images.githubusercontent.com/81120004/195458904-f4e58c22-5af3-4f39-a54b-e1e929360892.png)
- Create database;
![image](https://user-images.githubusercontent.com/81120004/195459334-a4b726fc-63e1-41ab-a9f6-30a010b9ea41.png)
![image](https://user-images.githubusercontent.com/81120004/195459608-dd1f56c5-6ba2-446f-883d-71f9155b8da4.png)
- Vá para "database" e clique em "connect";
![image](https://user-images.githubusercontent.com/81120004/195460207-233e8873-5cb1-4307-829e-f2ee64946011.png)
- Connect your application;
![image](https://user-images.githubusercontent.com/81120004/195460301-4d7b4f33-a39c-41b0-83fb-cf899bd0ab40.png)
- Copie a string de conexão fornecida, substitua a tag "\<password\>" pela sua senha do mongoDB. No arquivo [application.properties](https://github.com/viniporto/apiChampsLol/blob/master/src/main/resources/application.properties), copie e cole "spring.data.mongodb.uri=" + a string de conexão fornecida;
![image](https://user-images.githubusercontent.com/81120004/195460470-72d039ed-86f3-4b88-a6c9-57af09277674.png)
![image](https://user-images.githubusercontent.com/81120004/195461445-a5693438-18b5-4d32-8083-f825841c4840.png)
- Adicione o nome do database após "mongodb.net/";
![image](https://user-images.githubusercontent.com/81120004/195463528-54790bd7-0c21-4b1b-87fc-9021b22cb91d.png)
- No arquivo [Champ.java](https://github.com/viniporto/apiChampsLol/blob/master/src/main/java/com/viniporto/apiChampsLol/Champ.java) substitua a collection na annotation @Document pelo nome da collection criada no mongoDB;
![image](https://user-images.githubusercontent.com/81120004/195461928-d29b300a-9ec7-485c-a6fc-a6ff2fb3e440.png)


#### 🎲 Rodando o Backend (servidor)

```bash

# Clone este repositório
$ git clone git@github.com:viniporto/apiChampsLol.git

# Acesse a pasta do projeto no terminal/cmd
$ cd apiChampsLol

# Execute a aplicação
$ mvn spring-boot:run

# O servidor inciará na porta:8080 - acesse http://localhost:8080/champs 

```

---

## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

#### **Server**  ([Spring Boot](https://spring.io/projects/spring-boot))

-   **[Spring Boot](https://spring.io/projects/spring-boot)**
-   **[MongoDB](https://www.mongodb.com/cloud/atlas/lp/try4?utm_content=rlsavisitor&utm_source=google&utm_campaign=search_gs_pl_evergreen_atlas_core_retarget-brand_gic-null_amers-all_ps-all_desktop_eng_lead&utm_term=mongodb&utm_medium=cpc_paid_search&utm_ad=e&utm_ad_campaign_id=14412646314&adgroup=131761122172&gclid=Cj0KCQjwy5maBhDdARIsAMxrkw0TKH0bUihAmfj-4tAWMUMM-PGohN3KQW3NzEqDGA4IaWaSIWgo2WIaAs3iEALw_wcB)**

> Veja o arquivo  [pom.xml](https://github.com/viniporto/apiChampsLol/blob/master/pom.xml)

#### **Utilitários**

-   Hospedagem:  **[Heroku](https://dashboard.heroku.com/login)**
-   Editor:  **[Visual Studio Code](https://code.visualstudio.com/)**
-   Teste de API:  **[Insomnia](https://insomnia.rest/)**

---

## 💪 Como contribuir para o projeto

1. Faça um **fork** do projeto.
2. Crie uma nova branch com as suas alterações: `git checkout -b my-feature`
3. Salve as alterações e crie uma mensagem de commit contando o que você fez: `git commit -m "feature: My new feature"`
4. Envie as suas alterações: `git push origin my-feature`
> Caso tenha alguma dúvida confira este [guia de como contribuir no GitHub](https://imasters.com.br/desenvolvimento/como-contribuir-com-um-projeto-no-github)

---

## 🦸 Autor

<a href="https://github.com/ViniPorto">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/81120004?v=4" width="100px;" alt=""/>
 <br />
 <sub><b>Vinícius Porto</b></sub></a> <a href="https://www.linkedin.com/in/vinicius-porto-9a1996209/" title="Linkedin Vinícius Porto">🚀</a>
 <br />

[![Linkedin Badge](https://img.shields.io/badge/-Vinicius-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/vinicius-porto-9a1996209/)](https://www.linkedin.com/in/vinicius-porto-9a1996209/) 
[![Gmail Badge](https://img.shields.io/badge/-leinateporto@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:leinateporto@gmail.com)](mailto:leinateporto@gmail.com)

---

## 📝 Licença

Este projeto esta sobe a licença [MIT](./LICENSE).

Feito com ❤️ por Vinícius Porto 👋🏽 [Entre em contato!](https://www.linkedin.com/in/vinicius-porto-9a1996209/)
