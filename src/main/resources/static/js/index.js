/* ===============================================================================
                                        VARIABLES
================================================================================== */
const dropdown = document.getElementById("dropdown");
let isLogin = false; 

/* ==============================================================================
                                      DROPDOWN
================================================================================= */
let dropdownContent = `
    <li><h6 class="dropdown-header">Hello, <span>John</span>!</h6></li>
    <li><a class="dropdown-item" href="/profile"><i class="fas fa-user me-2"></i>Profile</a></li>
    <li><a class="dropdown-item" href="/orders"><i class="fas fa-box me-2"></i>Orders</a></li>
    <li><a class="dropdown-item" href="/wishlist"><i class="fas fa-heart me-2"></i>Wishlist</a></li>
    <li><hr class="dropdown-divider"></li>
`;

if (isLogin) {
    dropdownContent += `
        <li><a class="dropdown-item" href="/logout"><i class="fas fa-sign-out-alt me-2"></i>Logout</a></li>
    `;
} else {
    dropdownContent += `
        <li><a class="dropdown-item" href="/login"><i class="fas fa-sign-in-alt me-2"></i>Login</a></li>
    `;
}



document.querySelector("form").addEventListener("submit", function(e) {
        const password = document.getElementById("password").value;
        const confirmPassword = document.getElementById("confirmPassword").value;
        if (password !== confirmPassword) {
            e.preventDefault();
            alert("Passwords do not match!");
        }
    });



dropdown.innerHTML = dropdownContent;

console.log(dropdown);
