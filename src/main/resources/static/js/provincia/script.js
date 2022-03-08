"use strict";

const URL = 'http://localhost:9006/popolazione/api/set-province';
let SX = document.getElementById("sinistra");
let DX = document.getElementById("destra");
let selezione = null;

document.addEventListener('DOMContentLoaded', e => {

    SX = document.getElementById("sinistra");
    DX = document.getElementById("destra");
    
    let regione = document.getElementById("regione_id").textContent;

	let findButton = document.getElementById("find");
	findButton.addEventListener('click',findProvincia);

    fetch(URL+`?regione=${encodeURIComponent(regione)}`,{
        method: 'GET'
      }).then(e => e.json()).then(comuni => {
        
        let output = '<select class="form-control" id="tendina" onchange="selezionaProvincia()">';
         output+='<option>'+"Scegli il comune"+'</option>';
        for (const comune of comuni) {
            output += `<option data-comune_id="${comune.id}">${comune.comune}</option>`;
        }
        output += '</select>';
        
        SX.innerHTML = output;
    
    });
});

function selezionaProvincia() {
    let nodeSelected = document.getElementById('tendina').selectedOptions[0];
    let scelta = tendina.value;
    
	selezione = nodeSelected.dataset.comune_id;
    //window.location=scelta+'/provincia';
}

function findProvincia(event){
	window.location=`../comune/${selezione}`;
}