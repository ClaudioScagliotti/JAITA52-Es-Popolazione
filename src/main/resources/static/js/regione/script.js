"use strict";

const URL = 'http://localhost:9006/popolazione/api/nomi-regioni';
let SX = document.getElementById("sinistra");
let DX = document.getElementById("destra");
let selezione = null;
let scelta = null;
document.addEventListener('DOMContentLoaded', e => {

    SX = document.getElementById("sinistra");
    DX = document.getElementById("destra");

    

    let findButton = document.getElementById("find");
	findButton.addEventListener('click',findProvincia);
    
    fetch(URL).then(e => e.json()).then(cat => {
    
        let output = '<select class="form-control" id="tendina" onchange="selezionaRegione()">';
        output+='<option>'+"Scegli la provincia"+'</option>';
        for (const categoria of cat) {
            output += '<option>'+categoria +'</option>';
        }
        output += '</select>';
        
        SX.innerHTML = output;
    
    });
});



function selezionaRegione() {
   
   scelta = tendina.value;
    
	
}

function findProvincia(event){
	window.location=scelta+'/provincia';
}
