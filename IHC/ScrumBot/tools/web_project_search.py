from duckduckgo_search import DDGS

def search_similar_projects(query, max_results=3):
    try:
        results = []
        with DDGS() as ddgs:
            search_query = f"{query} site:github.com"
            for r in ddgs.text(search_query, max_results=max_results):
                results.append({
                    "title": r.get("title"),
                    "href": r.get("href"),
                    "body": r.get("body")
                })
        return results if results else fallback_search(query)
    except Exception:
        return fallback_search(query)

def fallback_search(query):
    base_url = "https://github.com/search?q="
    query_url = f"{base_url}{query.replace(' ', '+')}"
    return [{
        "title": "GitHub Search (Manual Fallback)",
        "href": query_url,
        "body": "Click to view similar projects directly on GitHub."
    }]