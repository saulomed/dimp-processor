sudo systemctl start docker
sudo systemctl enable docker

docker-compose up --build

sudo usermod -aG docker ${USER}

http://localhost:8080/h2-console

jdbc:h2:mem:dimpdb
jdbc:h2:file:/app/h2-data/dimpdb

 ✔ Container dimp-processor        Removed                                                                                                                                                                                               0.0s 
 ✔ Container metabase 


Agora, siga estes passos:

Inicie tudo com o Docker Compose: No diretório dimp-processor, execute:

docker-compose up --build
(Aguarde um pouco, pois o Metabase pode demorar um minuto para iniciar pela primeira vez).

Acesse o Metabase: Abra seu navegador e acesse http://localhost:3000.

Configure o Metabase:

Você verá uma tela de boas-vindas. Siga os passos criando sua conta de administrador.
Na etapa "Adicionar seus dados", selecione o banco de dados H2.
Conecte o Metabase ao Banco de Dados H2: Preencha o formulário de conexão com os seguintes dados:

Nome do Banco de Dados: DIMP DB (ou o nome que preferir)
Host: dimp-processor (este é o nome do nosso outro serviço na rede do Docker)
Porta: 9092
Caminho do arquivo do banco de dados: /app/h2-data/dimpdb
Usuário: sa
Senha: (deixe em branco)
Crie sua primeira Análise (Exemplo):

Após conectar, clique em "Faça uma pergunta" (ou "Ask a question").
Selecione "Dados brutos" e escolha a tabela DIM_1115.
Clique em "Visualizar". Você verá os dados brutos da tabela.
Agora, clique em "Resumir".
No campo "A métrica que você quer ver", escolha "Soma de..." e selecione a coluna "VALOR".
No campo "Agrupar por", escolha "DT_OP".
Clique em "Visualizar". O Metabase irá gerar automaticamente um gráfico de barras mostrando a soma dos valores das transações por dia.


DIMP Processor: http://localhost:8080
Metabase: http://localhost:3000