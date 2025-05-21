import gradio as gr
import time
import os
from datetime import datetime
from ollama_agent import call_ollama
from tools.backlog_pdf_writter import generate_backlog_pdf
from tools.pdf_scraper import extract_sections_from_pdf
from tools.github_search import search_similar_projects_github  
from dotenv import load_dotenv

load_dotenv()


def format_projects_for_output(projects):
    if not projects:
        return "No similar projects found."
    output = ""
    for i, p in enumerate(projects, 1):
        output += f"📌 {p['title']}\n🔗 {p['href']}\n📝 {p['body']}\n\n"
    return output.strip()

def save_log(entry, resumo, backlog, tarefas, duration):
    timestamp = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    log_content = f"""
==================== {timestamp} ====================
📥 Entrada:
{entry}

📄 Resumo:
{resumo.strip()}

🧾 Backlog:
{backlog.strip()}

🧩 Tarefas:
{tarefas.strip()}

⏱ Tempo de processamento: {duration:.2f} segundos
=====================================================
"""
    os.makedirs("logs", exist_ok=True)
    with open("logs/history.log", "a", encoding="utf-8") as log_file:
        log_file.write(log_content)

def parse_backlog_to_items(text):
    lines = [line.strip() for line in text.strip().split("\n") if line.strip()]
    items = []
    prioridade_map = {
        "High": "Alta",
        "Medium": "Média",
        "Low": "Baixa"
    }

    for idx, line in enumerate(lines, 1):
        if "I want" not in line or "|" not in line:
            continue
        try:
            prioridade_raw, conteudo = line.split("|", 1)
            prioridade = prioridade_map.get(prioridade_raw.strip(), "Média")
            user_story = conteudo.replace("User Story:", "").strip()

            items.append({
                "id": idx,
                "prioridade": prioridade,
                "user_story": user_story
            })
        except Exception:
            continue

    return items

def load_prompt(file, content):
    with open(f"prompts/{file}", "r", encoding="utf-8") as f:
        return f.read().replace("{conteudo}", content)

def process_pdf_input(file):
    start = time.time()

    sections = extract_sections_from_pdf(file.name)
    context = (
        f"{sections['Project Name']}\n\n"
        f"{sections['Objective']}\n\n"
        f"{sections['Main Features']}\n\n"
        f"{sections['Technical Requirements']}"
    )

    resumo = call_ollama(load_prompt("summarize.txt", context))
    backlog = call_ollama(load_prompt("generate_backlog_items.txt", context))
    tarefas = call_ollama(load_prompt("split_tasks.txt", context))
    backlog_items = parse_backlog_to_items(backlog)
    pdf_path = generate_backlog_pdf(backlog_items)

    # Cria uma descrição curta com Ollama para usar como busca no GitHub
    query_prompt = load_prompt("web_search_query.txt", context)
    search_query = call_ollama(query_prompt).strip()

    # Busca usando a GitHub API
    similar_projects = search_similar_projects_github(search_query)
    formatted_projects = format_projects_for_output(similar_projects)

    duration = time.time() - start
    save_log(context, resumo, backlog, tarefas, duration)

    return resumo, backlog, tarefas, f"PDF saved in: {pdf_path}", formatted_projects

iface = gr.Interface(
    fn=process_pdf_input,
    inputs=gr.File(label="Upload Project PDF", file_types=[".pdf"]),
    outputs=[
        gr.Textbox(label="Project Summary"),
        gr.Textbox(label="Product Backlog"),
        gr.Textbox(label="Task Breakdown"),
        gr.Textbox(label="Backlog PDF Path"),
        gr.Textbox(label="Similar Open Source Projects"),
    ],
    title="ScrumBot - Powered by GitHub Search"
)

if __name__ == "__main__":
    iface.launch()