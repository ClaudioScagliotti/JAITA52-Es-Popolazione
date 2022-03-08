

function findProvincia(event){
	window.location=`/popolazione`;
}

document.addEventListener('DOMContentLoaded', e => {
    let findButton = document.getElementById("indietro");
	findButton.addEventListener('click',findProvincia);
});