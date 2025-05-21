import fitz  # PyMuPDF

def extract_sections_from_pdf(pdf_path):
    doc = fitz.open(pdf_path)
    full_text = "\n".join([page.get_text() for page in doc])
    doc.close()

    sections = {
        "Project Name": "",
        "Objective": "",
        "Main Features": "",
        "Technical Requirements": "",
        "Target Audience": "",
        "Additional Notes": ""
    }

    current_section = None
    for line in full_text.split("\n"):
        line = line.strip()
        if not line:
            continue

        if line in sections:
            current_section = line
        elif current_section:
            sections[current_section] += line + " "

    return sections