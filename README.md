# CRUD  Java

---

# Programação Orientada a Objetos

## Desenvolvimento de um CRUD com Java, IntelliJ IDEA, Maven e PostgreSQL

### author: rogerio-silva date: \today
---

# Sumário

1. [Configuração do ambiente de desenvolvimento](#configuração-do-ambiente-de-desenvolvimento)
2. [Configuração do ambiente de desenvolvimento (continuação)](#configuração-do-ambiente-de-desenvolvimento-continuação)
3. [Desenvolvimento do código](#desenvolvimento-do-código)
4. [Testando o CRUD](#testando-o-crud)
5. [Considerações finais](#considerações-finais)

---

# Configuração do ambiente de desenvolvimento

## Instalação do PostgreSQL no Ubuntu

Fonte: [Adaptado de (DioLinux, 2021)](https://www.dio.me/articles/instale-o-postgresql-com-pgadmin4-no-ubuntu-2004)

Crie a configuração do repositório de arquivos:

```shell
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt $ (lsb_release -cs) -pgdg main"> /etc/apt/sources.list.d/pgdg.list' 
```

Importe a chave de assinatura do repositório:

```shell
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
```

Atualize as listas de pacotes:

```shell
sudo apt-get update
```

Instale a versão mais recente do PostgreSQL.
Se você quiser uma versão específica, use 'postgresql-12' ou semelhante em vez de 'postgresql':

```shell 
sudo apt-get -y install postgresql
```

### Configuração do PostgreSQL

Depois de instalar o PostgreSQL, os comandos abaixo podem ser usados ​​para parar, iniciar, habilitar e verificar seu
status

```
sudo systemctl stop postgresql.service 
sudo systemctl start postgresql.service
sudo systemctl enable postgresql.service
sudo systemctl status postgresql.service 
```

Depois de instalado seu SGBD postgres, como criar seu 1° usuário?
Primeiro entre com seu super usuário

```shell
 sudo su 
 ```

Entre no banco postgres.

```shell
su postgres
```

Depois entre com o comando:

```shell
psql
```

### Configuração de usuário e senha PostgreSQL Linux

Criar usuário no PostgreSQL

```postgresql
CREATE USER <nomedousuario> SUPERUSER INHERIT CREATEDB CREATEROLE;
```

Alterar senha do usuário no PostgreSQL

```postgresql
ALTER
USER
<nomedousuario> PASSWORD 'senha';
```

## Instalação do pgAdmin4

Instale a chave pública para o repositório:

```shell
sudo curl https://www.pgadmin.org/static/packages_pgadmin_org.pub | sudo apt-key add
```

Crie o arquivo de configuração do repositório:

```shell
sudo sh -c 'echo "deb https://ftp.postgresql.org/pub/pgadmin/pgadmin4/apt/$(lsb_release -cs) pgadmin4 main"> /etc/apt/sources.list.d/pgadmin4.list && apt update '
```

Instale para os modos desktop e web:

```shell
sudo apt install pgadmin4
```

---

# Configurando o *database Server* no pgAdmin

- Abra o pgAdmin4
- Clique com o botão direito do mouse em *Servers* e selecione *Create* > *Server...* ou clique em *Add New Server* na
  janela **Welcome** da aba *Dashboard*

  ![pgAdmin#1.png](img%2FpgAdmin%231.png)


- Na guia *General*, insira um nome para o servidor

  ![pgAdmin#2.png](img%2FpgAdmin%232.png)


- Na guia *Connection*, insira as informações do servidor PostgreSQL. Insira o endereço do servidor em *Host
  name/address*, o número da porta em *Port* (mantenha a sugestão padrão: 5432), o nome do usuário em *Username* e a
  senha em *Password*. Clique em *Save*

  ![pgAdmin#3.png](img%2FpgAdmin%233.png)

- Clique com o botão direito do mouse no servidor criado e selecione *Connect*. Insira a senha do usuário do PostgreSQL,
  caso seja solicitada. Clique em *OK*. O servidor PostgreSQL estará conectado

  ![pgAdmin#4.png](img%2FpgAdmin%234.png)

- Clique com o botão direito do mouse em *Databases* e selecione *Create* > *Database...*

  ![pgAdmin#7.png](img%2FpgAdmin%237.png)

- Na guia *General*, insira um nome para o banco de dados. Clique em *Save*. O banco de dados estará criado.

  ![pgAdmin#8.png](img%2FpgAdmin%238.png)

- Clique com o botão direito do mouse no banco de dados criado e selecione *Query Tool*
  ![pgAdmin#9.png](img%2FpgAdmin%239.png)

- Insira o comando SQL para criar a tabela. Clique em *Execute/Refresh* (F5). A tabela estará criada

  ![pgAdmin#10.png](img%2FpgAdmin%2310.png)

# Configuração do ambiente de desenvolvimento (IDE e Maven)

- Configuração do ambiente no IntelliJ IDEA

- Criação de um novo projeto Maven

---

## Desenvolvimento do código

- Estrutura básica de um projeto Java com POO e Maven
- Criação das classes principais do CRUD
- Implementação dos métodos para criar, ler, atualizar e deletar registros no PostgreSQL

---

## Testando o CRUD

- Demonstração de testes com interface gráfica ou API REST

---

## Considerações finais

- Recapitulação dos pontos principais
- Recursos adicionais para aprofundamento