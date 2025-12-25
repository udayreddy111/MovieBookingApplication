
// assets/js/pages/viewMovies.js

/**
 * Opens the Movies modal for a given theatre.
 * Fetches movies and renders them grouped by date.
 */
async function openMoviesModal(theatreId, theatreName) {
  clearToast("moviesToast");

  // Set modal title
  const titleEl = document.getElementById("moviesModalLabel");
  titleEl.textContent = `Movies • ${theatreName} (ID: ${theatreId})`;

  const listEl = document.getElementById("moviesList");
  listEl.innerHTML = `<div class="text-secondary">Loading movies...</div>`;

  // Fetch from MovieRegistrationModule
  try {
    const { status, ok, data } = await getMoviesByTheatreId(theatreId);

    if (!ok) {
      const msg = (data && data.message) ? data.message : `Failed with status ${status}`;
      showToast("moviesToast", "danger", `❌ ${msg}`);
      listEl.innerHTML = "";
    } else {
      renderMoviesList(Array.isArray(data) ? data : []);
    }
  } catch (err) {
    showToast("moviesToast", "danger", `❌ ${err.message || "Unexpected error"}`);
    listEl.innerHTML = "";
  }

  // Show modal
  const modalEl = document.getElementById("moviesModal");
  const modal = new bootstrap.Modal(modalEl, { keyboard: true });
  modal.show();
}

/**
 * Renders movies array into the modal.
 * Expected item fields:
 * - movienames, language, moviedate (YYYY-MM-DD), moviestarttime, price, movieId, theaterid
 */
function renderMoviesList(movies) {
  const listEl = document.getElementById("moviesList");
  listEl.innerHTML = "";

  if (!Array.isArray(movies) || movies.length === 0) {
    listEl.innerHTML = `
      <div class="alert alert-secondary mb-0">No movies available for this theatre.</div>`;
    return;
  }

  // Group by date for a cleaner presentation
  const grouped = movies.reduce((acc, m) => {
    const d = m.moviedate || "Unknown date";
    acc[d] = acc[d] || [];
    acc[d].push(m);
    return acc;
  }, {});

  // Build sections per date
  Object.keys(grouped).sort().forEach((date) => {
    const section = document.createElement("div");
    section.className = "mb-3";

    let itemsHtml = grouped[date].map((m) => {
      const price = (m.price != null) ? `₹${m.price}` : "—";
      const lang = (m.language || "").toUpperCase();
      return `
        <div class="border rounded p-2 mb-2 border-secondary">
          <div class="d-flex justify-content-between">
            <div>
              <div class="fw-bold">${m.movienames}</div>
              <div class="text-secondary small">Language: ${lang}</div>
              <div class="text-secondary small">Start: ${m.moviestarttime}</div>
            </div>
            <div class="text-end">
              <div class="badge text-bg-info">Price: ${price}</div>
              <div class="small text-secondary">Movie ID: ${m.movieId}</div>
            </div>
          </div>
        </div>
      `;
    }).join("");

    section.innerHTML = `
      <h6 class="mb-2">📅 ${date}</h6>
      ${itemsHtml}
    `;

    listEl.appendChild(section);
  });
}
