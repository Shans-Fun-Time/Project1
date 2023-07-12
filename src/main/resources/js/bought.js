const boughtCheckbox = document.getElementById("bought");

boughtCheckbox.addEventListener("click", function() {
    boughtCheckbox.checked = !boughtCheckbox.checked;
});