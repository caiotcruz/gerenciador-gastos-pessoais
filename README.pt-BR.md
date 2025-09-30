📊 Gerenciador de Gastos Pessoais

Um sistema desktop simples e eficiente para gerenciamento de finanças pessoais, desenvolvido em Java.
Este projeto foi construído como peça de portfólio, demonstrando habilidades em desenvolvimento Java, arquitetura em camadas e persistência de dados local.

✨ Funcionalidades

CRUD de Lançamentos
Adicionar, listar, atualizar e remover receitas e despesas.

Persistência Local (JSON)
Todos os dados são armazenados em arquivos JSON, dispensando banco de dados externo.

Interface de Linha de Comando (CLI)
Versão funcional para uso e testes diretos no console.

Interface Gráfica (JavaFX) – Em desenvolvimento
Uma UI moderna e intuitiva para facilitar a interação.

Relatórios e Exportação – Planejado

Relatórios mensais e por categoria

Exportação de dados para Excel (.xlsx)

Visualização de Dados – Planejado
Gráficos para análise da distribuição de gastos ao longo do tempo.

🛠️ Tecnologias Utilizadas

Java 21

Apache Maven (gerenciador de dependências)

Google Gson (manipulação de JSON)

JavaFX (interface gráfica – em desenvolvimento)

Git & GitHub (versionamento)

🚀 Como Executar o Projeto
Pré-requisitos

JDK 21 ou superior instalado
Apache Maven configurado nas variáveis de ambiente

Passos
# Clonar o repositório
git clone https://github.com/caiotcruz/gerenciador-gastos-pessoais.git

# Acessar o diretório do projeto
cd gerenciador-gastos-pessoais

# Compilar o projeto
mvn clean compile

# Executar a versão console
mvn exec:java


🏛️ Estrutura do Projeto
src/main/java/
├── Main.java          # Ponto de entrada (CLI)
├── model/             # Classes de dados (POJOs)
├── repository/        # Acesso e manipulação de dados (JSON)
├── service/           # Regras de negócio (planejado)
├── ui/                # Interface gráfica com JavaFX
└── util/              # Classes utilitárias 


👨‍💻 Autor

Caio T. Cruz

LinkedIn: https://www.linkedin.com/in/caio-teixeira-da-cruz

📧 Email: caiotcruz@gmail.com

📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.