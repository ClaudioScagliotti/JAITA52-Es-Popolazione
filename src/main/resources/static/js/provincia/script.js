"use strict";

const URL = 'http://localhost:9006/popolazione/api/set-province';
let SX = document.getElementById("sinistra");
let DX = document.getElementById("destra");

document.addEventListener('DOMContentLoaded', e => {

    SX = document.getElementById("sinistra");
    DX = document.getElementById("destra");
    
    let regione = document.getElementById("regione_id").textContent;

    fetch(URL+`?regione=${encodeURIComponent(regione)}`,{
        method: 'GET'
      }).then(e => e.json()).then(cat => {
    
        let output = '<select class="form-control" id="tendina" onchange="selezionaProvincia()">';
        for (const categoria of cat) {
            output += '<option>'+categoria +'</option>';
        }
        output += '</select>';
        
        SX.innerHTML = output;
    
    });
});

function selezionaProvincia() {
    let tendina = document.getElementById('tendina');
    let scelta = tendina.value;
    
    window.location=scelta+'/provincia';
}