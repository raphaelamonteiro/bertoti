from fpdf import FPDF
import os
import textwrap

def generate_backlog_pdf(items, output_path="generated_backlogs/backlog_produto.pdf"):
    os.makedirs(os.path.dirname(output_path), exist_ok=True)

    pdf = FPDF()
    pdf.set_auto_page_break(auto=True, margin=15)
    pdf.add_page()

    pdf.set_font("Arial", "B", 14)
    pdf.cell(200, 10, "Product Backlog", ln=True, align="C")
    pdf.ln(10)

    # Cabeçalhos
    pdf.set_font("Arial", "B", 12)
    pdf.cell(15, 10, "ID", border=1)
    pdf.cell(30, 10, "Prioridade", border=1)
    pdf.cell(145, 10, "User Story", border=1)
    pdf.ln()

    # Conteúdo
    pdf.set_font("Arial", "", 11)
    for item in items:
        user_story = item["user_story"]
        wrapped = textwrap.wrap(user_story, width=100)
        line_height = 6
        row_height = line_height * len(wrapped)

        # Salva posição inicial
        x, y = pdf.get_x(), pdf.get_y()

        # ID
        pdf.multi_cell(15, row_height, str(item["id"]), border=1)
        pdf.set_xy(x + 15, y)

        # Prioridade
        pdf.multi_cell(30, row_height, item["prioridade"], border=1)
        pdf.set_xy(x + 45, y)

        # User story (com quebra de linha interna)
        pdf.multi_cell(145, line_height, "\n".join(wrapped), border=1)

    pdf.output(output_path)
    return output_path