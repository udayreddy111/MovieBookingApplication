
// assets/js/pages/addTheatre.js

document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("theatreForm");

  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    clearToast("theatreToast");

    const fd = new FormData(form);
    const theatreName = (fd.get("theatreName") || "").trim();
    const location = (fd.get("location") || "").trim().toUpperCase();
    const seats = Number(fd.get("seats"));

    if (!theatreName || !location || !seats || seats <= 0) {
      showToast("theatreToast", "warning", "Please fill all fields correctly.");
      return;
    }

    const submitBtn = form.querySelector("button[type='submit']");
    submitBtn.disabled = true;
    submitBtn.textContent = "Saving...";

    try {
      const { status, data } = await addTheatre({ theatreName, location, seats });

      if (status === 200) {
        showToast("theatreToast", "success", "✅ Theatre saved successfully!");
        form.reset();
      } else {
        const msg = (data && data.message) ? data.message : `Request failed with status ${status}`;
        showToast("theatreToast", "danger", `❌ ${msg}`);
      }
    } catch (err) {
      showToast("theatreToast", "danger", `❌ ${err.message || "Unexpected error"}`);
    } finally {
      submitBtn.disabled = false;
      submitBtn.textContent = "Add Theatre";
    }
  });
});
``
