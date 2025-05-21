# ScrumBot 🤖📋

O **ScrumBot** é um agente inteligente baseado em LLMs que automatiza as primeiras etapas de planejamento ágil a partir de uma descrição de projeto. Ele gera:

- ✔️ Resumo do projeto
- 📋 Backlog do Produto (com PDF formatado)
- 🧩 Tarefas iniciais organizadas
- 🌐 Sugestões de projetos semelhantes via GitHub
- 📄 Logs detalhados de execução

---

## ✅ Requisitos

- [Python 3.10+](https://www.python.org/downloads/)
- [Ollama](https://ollama.com) instalado e rodando com o modelo `llama3`
- Conta no GitHub com token de acesso (para busca via API)
- Sistema operacional compatível com Ollama (Windows/Mac/Linux)

---

## 🚀 Passo a Passo para Rodar o Projeto

### 1. Instale o Ollama

Acesse: https://ollama.com  
Siga as instruções de instalação para seu sistema operacional.

---

### 2. Baixe o modelo `llama3` no Ollama

```bash
ollama pull llama3
```

E inicie o modelo em um terminal separado:

```bash
ollama run llama3
```

---

### 3. Clone o repositório

```bash
git clone https://github.com/seu-usuario/scrumbot.git
cd scrumbot
```

Ou extraia o ZIP e acesse a pasta.

---

### 4. Crie um ambiente virtual (recomendado)

```bash
python -m venv venv
```

Ative:

- No **Windows**:
  ```bash
  venv\Scripts\activate
  ```
- No **Linux/macOS**:
  ```bash
  source venv/bin/activate
  ```

---

### 5. Instale as dependências

```bash
pip install -r requirements.txt
```

---

### 6. Crie o arquivo `.env`

Na raiz do projeto, crie um arquivo `.env` com o seguinte conteúdo:

```env
GITHUB_TOKEN=seu_token_aqui
```

> O token pode ser gerado em [github.com/settings/tokens](https://github.com/settings/tokens) com acesso público de leitura a repositórios.

---

### 7. Execute o ScrumBot

```bash
python main.py
```

Abra o navegador e acesse:

```
http://127.0.0.1:7860
```

---

## 🗂 Estrutura básica

```
scrumbot/
├── main.py
├── prompts/
├── tools/
│   ├── backlog_pdf_writter.py
│   ├── pdf_scraper.py
│   └── github_search.py
├── generated_backlogs/
├── logs/
├── requirements.txt
├── .env
```

---

## 💡 Exemplo de uso

Você pode:

- Digitar a **descrição do projeto**
- Ou **enviar um PDF** seguindo o [modelo recomendado](Modelo_Projeto_ScrumBot.pdf)

O ScrumBot irá retornar:

- ✅ Resumo automático do projeto
- 📋 Backlog formatado e salvo como PDF
- 🧩 Lista de tarefas divididas
- 🌐 Sugestões de projetos semelhantes no GitHub
- 📂 Caminho do PDF gerado e log completo da execução

---

## 🧠 Desenvolvido com foco em produtividade ágil

Feito para equipes que desejam acelerar a fase de planejamento com ajuda da IA. Ideal para:

- Product Owners
- Gerentes de Projeto
- Equipes Ágeis e Squads

---

Desfrute da automação com inteligência!
