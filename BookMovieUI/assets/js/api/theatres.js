
// assets/js/api/theatres.js

/**
 * POST /theatres/addTheater
 * Payload: { theatreName, location, seats }
 * Success criteria (as requested): status === 200
 */
async function addTheatre(payload) {
  return httpRequest("/theatres/addTheater", {
    method: "POST",
    body: JSON.stringify(payload),
  });
}

/**
 * GET /theatres/location/{location}
 * (For future browse page)
 */
async function getTheatresByLocation(location) {
  return httpRequest(`/theatres/location/${encodeURIComponent(location)}`, {
    method: "GET",
  });
}
