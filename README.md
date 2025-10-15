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

## Como Rodar o Projeto (Opções)

Existem duas maneiras de executar o ambiente: construindo a imagem localmente ou usando a imagem pré-construída do Docker Hub.

### Opção 1: Construindo a Imagem Localmente (Build Local)

Esta abordagem é ideal para desenvolvimento e para quando você faz alterações no código-fonte.

#### Pré-requisitos

- **Docker**
- **Docker Compose**

#### Passo a Passo

1. **Navegue até a raiz do projeto:**
   Certifique-se de que você está no diretório `dimp-processor`, onde o arquivo `docker-compose.yml` principal está localizado.

2. **Crie a pasta para os arquivos DIMP:**
   ```bash
   mkdir -p dimp-files
   ```

3. **Suba os contêineres:**
   Execute o comando a seguir para construir a imagem da aplicação e iniciar todos os serviços.
   ```bash
   docker-compose up --build -d
   ```

### Opção 2: Usando a Imagem do Docker Hub (Recomendado para Produção/Staging)

Esta abordagem é mais rápida, pois utiliza uma imagem já pronta (`saulomed/dimp-processor:latest`), sem a necessidade de compilar o projeto.

#### Pré-requisitos

- **Docker**
- **Docker Compose**

#### Passo a Passo

1. **Navegue até o diretório `docker-run`:**
   ```bash
   cd dimp-processor/docker-run
   ```

2. **Crie a pasta para os arquivos DIMP (se não existir):**
   O diretório `dimp-files` é mapeado para o contêiner e é onde a aplicação busca os arquivos a serem processados.
   ```bash
   mkdir -p dimp-files
   ```

3. **Suba os contêineres:**
   Execute o comando a seguir para baixar as imagens necessárias e iniciar os serviços.
   ```bash
   docker-compose up -d
   ```

---

## Acessando os Serviços e Processando Arquivos

Após executar uma das opções acima:

1. **Coloque um arquivo DIMP para teste:**
   Copie um arquivo `.txt` no formato DIMP para o diretório `dimp-files` correspondente ao ambiente que você subiu (`./dimp-files` ou `./docker-run/dimp-files`). O serviço `dimp-processor` irá detectá-lo e processá-lo automaticamente.

2. **Verifique os logs (opcional):**
   Para acompanhar o processamento, você pode ver os logs da aplicação:
   ```bash
   # Para o ambiente de build local
   docker-compose logs -f dimp-processor

   # Para o ambiente do Docker Hub (dentro da pasta docker-run)
   docker-compose logs -f dimp-processor
   ```

3. **Acesse o Metabase (BI):**
   - Abra: [http://localhost:3000](http://localhost:3000)
   - No primeiro acesso, configure uma conta de administrador.
   - Conecte ao banco de dados **PostgreSQL** com as seguintes informações:
     - **Nome do Banco de Dados:** `dimpdb`
     - **Host:** `postgres`
     - **Porta:** `5432`
     - **Nome de usuário:** `user`
     - **Senha:** `password`

4. **Explore os Dados:**
   - Após a conexão, navegue em **"Navegar por dados"** para ver as tabelas DIMP ou em **"Faça uma pergunta"** para criar seus próprios dashboards.