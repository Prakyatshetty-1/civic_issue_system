const API = "";  // same origin — empty string means relative URLs

// ── Token helpers ──────────────────────────────────────────
function getToken()  { return localStorage.getItem("token"); }
function getRole()   { return localStorage.getItem("role"); }
function getName()   { return localStorage.getItem("name"); }
function getEmail()  { return localStorage.getItem("email"); }

function logout() {
    localStorage.clear();
    window.location.href = "/login.html";
}

// ── Authenticated fetch wrapper ────────────────────────────
async function apiFetch(url, options = {}) {
    const token = getToken();
    const headers = {
        "Content-Type": "application/json",
        ...(token && { "Authorization": `Bearer ${token}` }),
        ...options.headers
    };

    const response = await fetch(API + url, { ...options, headers });

    if (response.status === 401) {
        logout();
        return null;
    }

    if (response.status === 403) {
        alert("Access denied. You don't have permission for this action.");
        return null;
    }

    return response.json();
}

// ── Role guard — call at top of every protected page ───────
function requireAuth(expectedRole = null) {
    const token = getToken();
    const role = getRole();

    if (!token) {
        window.location.href = "/login.html";
        return;
    }

    if (expectedRole && role !== expectedRole) {
        alert("Access denied");
        window.location.href = "/login.html";
    }
}

// ── Status badge helper ────────────────────────────────────
function statusBadge(status) {
    const colors = {
        OPEN:        "background:#3B8BD4;color:#fff",
        ASSIGNED:    "background:#EF9F27;color:#fff",
        IN_PROGRESS: "background:#9F77DD;color:#fff",
        RESOLVED:    "background:#1D9E75;color:#fff"
    };
    return `<span style="padding:2px 10px;border-radius:12px;font-size:12px;
        font-weight:500;${colors[status] || ''}">${status}</span>`;
}
