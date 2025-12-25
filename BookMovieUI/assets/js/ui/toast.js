
// assets/js/ui/toast.js

function showToast(elementId, type, message) {
  const el = document.getElementById(elementId);
  el.classList.remove("d-none");
  el.innerHTML = `
    <div class="alert alert-${type} alert-dismissible fade show" role="alert">
      ${message}
      <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>`;
}

function clearToast(elementId) {
  const el = document.getElementById(elementId);
  el.classList.add("d-none");
  el.innerHTML = "";
}
