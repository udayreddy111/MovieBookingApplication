
// assets/js/api/movies.js
// MovieRegistrationModule API client

const MOVIE_API_BASE_URL = "http://localhost:8080/api";

/**
 * GET /movies/{id}
 * id = theatreId
 * Returns an array like:
 * [
 *   {
 *     "language": "telugu",
 *     "movieId": 1,
 *     "moviedate": "2025-12-25",
 *     "movienames": "Avathar-3",
 *     "moviestarttime": "10:10 PM",
 *     "price": 1150,
 *     "theaterid": 1
 *   },
 *   ...
 * ]
 */
async function getMoviesByTheatreId(theatreId) {
  const url = `${MOVIE_API_BASE_URL}/movies/${encodeURIComponent(theatreId)}`;
  const res = await fetch(url, {
    method: "GET",
    headers: { "Content-Type": "application/json" },
  });

  let data = null;
  try { data = await res.json(); } catch { /* non-JSON */ }

  return { status: res.status, ok: res.ok, data, raw: res };
}
