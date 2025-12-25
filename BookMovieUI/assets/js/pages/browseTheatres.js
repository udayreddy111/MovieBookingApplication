
// assets/js/pages/browseTheatres.js

function renderTheatres(theatres) {
  const grid = document.getElementById("theatreGrid");
  grid.innerHTML = "";

  if (!Array.isArray(theatres) || theatres.length === 0) {
    grid.innerHTML = `
      <div class="col-12">
        <div class="alert alert-secondary mb-0">No theatres found. Try another location.</div>
      </div>`;
    return;
  }

  theatres.forEach((t) => {
    const col = document.createElement("div");
    col.className = "col-md-4";

    const idBadge = t.id
      ? `<span class="badge rounded-pill text-bg-secondary">ID: ${t.id}</span>`
      : "";

    // Enable "View Movies" button and add data attributes
    col.innerHTML = `
      <div class="card h-100 bg-dark text-light border-secondary">
        <div class="card-body d-flex flex-column">
          <div class="d-flex justify-content-between align-items-center">
            <h5 class="card-title mb-0">${t.theatreName}</h5>
            ${idBadge}
          </div>
          <p class="card-text text-secondary mb-2">📍 ${t.location}</p>
          <div class="mb-3">
            <span class="badge rounded-pill bg-secondary">Seats: ${t.seats}</span>
          </div>
          <div class="mt-auto d-flex gap-2">
            <button
              class="btn btn-outline-info btn-sm view-movies-btn"
              data-theatre-id="${t.id ?? ""}"
              data-theatre-name="${t.theatreName}"
            >
              View Movies
            </button>
            <button class="btn btn-outline-primary btn-sm" disabled>Book (coming)</button>
          </div>
        </div>
      </div>
    `;
    grid.appendChild(col);
  });
}

document.addEventListener("DOMContentLoaded", () => {
  const input = document.getElementById("searchLocation");
  const btn = document.getElementById("btnSearch");
  const grid = document.getElementById("theatreGrid");

  async function search() {
    clearToast("browseToast");
    const location = (input.value || "").trim();
    if (!location) {
      showToast("browseToast", "warning", "Please enter a location.");
      return;
    }
    btn.disabled = true;
    btn.textContent = "Searching...";
    try {
      const { status, ok, data } = await getTheatresByLocation(location);
      if (!ok) {
        const msg = (data && data.message) ? data.message : `Failed with status ${status}`;
        showToast("browseToast", "danger", `⚠️ ${msg}`);
        renderTheatres([]);
        return;
      }
      renderTheatres(Array.isArray(data) ? data : []);
    } catch (err) {
      showToast("browseToast", "danger", `❌ ${err.message || "Unexpected error"}`);
      renderTheatres([]);
    } finally {
      btn.disabled = false;
      btn.textContent = "Search";
    }
  }

  // Search handlers
  btn.addEventListener("click", search);
  input.addEventListener("keydown", (e) => {
    if (e.key === "Enter") {
      e.preventDefault();
      search();
    }
  });

  // ✅ Delegate click for "View Movies" buttons
  grid.addEventListener("click", async (e) => {
    const btn = e.target.closest(".view-movies-btn");
    if (!btn) return;

    const theatreId = btn.getAttribute("data-theatre-id");
    const theatreName = btn.getAttribute("data-theatre-name");
    if (!theatreId) {
      showToast("browseToast", "warning", "Theatre ID is missing.");
      return;
    }

    // Load and show movies in modal (MovieRegistrationModule)
    await openMoviesModal(Number(theatreId), theatreName);
  });

  // Optional: auto search on load
  if (input.value) search();
});
