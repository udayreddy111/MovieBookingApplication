
// assets/js/api/http.js
const API_BASE_URL = "http://localhost:8081/api";

/**
 * Generic HTTP request wrapper using fetch.
 * Returns { status, ok, data, raw } for consistent handling.
 */
async function httpRequest(path, options = {}) {
  const url = `${API_BASE_URL}${path}`;
  const res = await fetch(url, {
    headers: { "Content-Type": "application/json", ...(options.headers || {}) },
    ...options,
  });

  let data = null;
  try {
    data = await res.json();
  } catch {
    // Non-JSON/empty body—keep data as null
  }

  return { status: res.status, ok: res.ok, data, raw: res };
}
