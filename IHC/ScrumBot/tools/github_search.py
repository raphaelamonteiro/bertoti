import requests
import os

def search_similar_projects_github(query, max_results=3):
    headers = {
        "Accept": "application/vnd.github+json"
    }

    token = os.getenv("GITHUB_TOKEN")  
    if token:
        headers["Authorization"] = f"Bearer {token}"

    params = {
        "q": f"{query}",
        "sort": "stars",
        "order": "desc",
        "per_page": 20  # Pegamos mais e filtramos
    }

    response = requests.get("https://api.github.com/search/repositories", headers=headers, params=params)

    if response.status_code != 200:
        return [{
            "title": "GitHub Search Fallback",
            "href": f"https://github.com/search?q={query.replace(' ', '+')}",
            "body": "Click to search manually"
        }]

    data = response.json()
    results = []
    for item in data.get("items", []):
        desc = item.get("description", "")
        if not desc or len(desc) < 15:
            continue  

        if item.get("stargazers_count", 0) < 5:
            continue 

        results.append({
            "title": item["full_name"],
            "href": item["html_url"],
            "body": desc.strip()
        })

        if len(results) == max_results:
            break

    if not results:
        results.append({
            "title": "GitHub Search Fallback",
            "href": f"https://github.com/search?q={query.replace(' ', '+')}",
            "body": "Click to search manually"
        })

    return results