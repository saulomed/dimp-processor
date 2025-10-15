# DIMP Processor

Este projeto é um processador de arquivos DIMP (Declaração de Informações de Meios de Pagamentos). Ele monitora um diretório em busca de novos arquivos de texto (.txt), processa-os linha por linha e persiste os dados em um banco de dados PostgreSQL.

O sistema também inclui uma plataforma de Business Intelligence (BI) pré-configurada (Metabase) para permitir a análise e visualização dos dados processados.

## Arquitetura e Frameworks

O sistema é construído em torno de uma arquitetura de microsserviços orquestrada com Docker Compose.

- **Aplicação Principal (`dimp-processor`):**
  - **Framework:** Spring Boot 2.7.5
  - **Linguagem:** Java 11
  - **Acesso a Dados:** Spring Data JPA (Hibernate)
  - **Lógica Principal:** A aplicação monitora um diretório de volume (`/data`) em busca de arquivos. Um `FileWatcherService` detecta novos arquivos e aciona o `DimpFileProcessorService`, que lê, analisa e salva os dados no banco.

- **Banco de Dados (`postgres`):**
  - **Sistema:** PostgreSQL (Imagem Docker `postgres:latest`)
  - **Finalidade:** Armazena todos os dados extraídos dos arquivos DIMP.

- **Business Intelligence (`metabase`):**
  - **Plataforma:** Metabase
  - **Finalidade:** Fornece uma interface web para criar dashboards e visualizações a partir dos dados armazenados no PostgreSQL.

## Como Realizar o Build do Projeto

Siga os passos abaixo para compilar a aplicação e gerar o arquivo `.jar`.

### Pré-requisitos

- **Java Development Kit (JDK):** Versão 11 ou superior.
- **Apache Maven:** Versão 3.6.3 ou superior.

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone <url-do-seu-repositorio>
   cd dimp-processor
   ```

2. **Execute o build com o Maven:**
   O comando a seguir irá compilar o código-fonte, executar testes e empacotar a aplicação em um arquivo JAR executável dentro do diretório `target/`.
   ```bash
   mvn clean package
   ```
   Ao final, o artefato `dimp-processor-1.0.0.jar` estará disponível no diretório `target/`.

## Como Rodar o Projeto com Docker

A maneira mais simples de executar todo o ambiente (aplicação, banco de dados e BI) é usando o Docker e o Docker Compose.

### Pré-requisitos

- **Docker**
- **Docker Compose**

### Passo a Passo

1. **Navegue até a raiz do projeto:**
   Certifique-se de que você está no diretório `dimp-processor`, onde o arquivo `docker-compose.yml` está localizado.

2. **Suba os contêineres:**
   Execute o comando a seguir para construir as imagens e iniciar todos os serviços em segundo plano (`-d`).
   ```bash
   docker-compose up --build -d
   ```
   Este comando irá:
   - Construir a imagem da aplicação `dimp-processor` a partir do `Dockerfile`.
   - Baixar e iniciar um contêiner do `PostgreSQL`.
   - Construir e iniciar um contêiner do `Metabase`.
   - Criar um volume (`postgres-data`) para persistir os dados do banco.
   - Criar um volume (`./dimp-files:/data`) para que a aplicação possa acessar os arquivos DIMP que você colocar no diretório `dimp-files`.

3. **Coloque um arquivo DIMP para teste:**
   Copie um arquivo `.txt` no formato DIMP para o diretório `dimp-files` na raiz do projeto. O serviço `dimp-processor` irá detectá-lo e processá-lo automaticamente.

4. **Verifique os logs (opcional):**
   Para acompanhar o processamento, você pode ver os logs da aplicação:
   ```bash
   docker-compose logs -f dimp-processor
   ```

## Exemplo de Utilização do BI (Metabase)

Após iniciar os contêineres, a plataforma de BI estará acessível no seu navegador.

1. **Acesse o Metabase:**
   Abra o seguinte endereço no seu navegador:
   [http://localhost:3000](http://localhost:3000)

2. **Configure o Metabase (Primeiro Acesso):**
   - Na primeira vez que você acessar, o Metabase pedirá para criar uma conta de administrador e conectar a um banco de dados.
   - Preencha as informações da sua conta.
   - Na tela de "Adicionar seus dados", selecione **PostgreSQL** e preencha com as seguintes informações (baseadas no `docker-compose.yml`):
     - **Nome do Banco de Dados:** `dimpdb`
     - **Host:** `postgres`
     - **Porta:** `5432`
     - **Nome de usuário:** `user`
     - **Senha:** `password`

3. **Explore os Dados:**
   - Após a conexão, o Metabase irá sincronizar e analisar as tabelas do banco `dimpdb`.
   - Você pode ir para a seção **"Navegar por dados"** para ver as tabelas (`dim_0000`, `dim_1100`, etc.).
   - Use a opção **"Faça uma pergunta"** para criar suas próprias consultas e visualizações (gráficos, tabelas, etc.) sobre os dados DIMP processados.
