"use strict";

const URL = 'http://localhost:9006/popolazione/api/nomi-regioni';
let SX = document.getElementById("sinistra");
let DX = document.getElementById("destra");

document.addEventListener('DOMContentLoaded', e => {

    SX = document.getElementById("sinistra");
    DX = document.getElementById("destra");
    
    fetch(URL).then(e => e.json()).then(cat => {
    
        let output = '<select class="form-control" id="tendina" onchange="cambiaCategoria()">';
        output+='<option>'+"Scegli la provincia"+'</option>';
        for (const categoria of cat) {
            output += '<option>'+categoria +'</option>';
        }
        output += '</select>';
        
        SX.innerHTML = output;
    
    });
});

function cambiaCategoria() {
    let tendina = document.getElementById('tendina');
    let scelta = tendina.value;
    
    window.location=scelta+'/provincia';
}