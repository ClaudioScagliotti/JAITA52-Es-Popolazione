"use strict";

const apiBaseURL = "/api";
let find_ISTAT_text = null;
let eta_table = null;
let tr_template = "";

document.addEventListener('DOMContentLoaded', event => {
    find_ISTAT_text = document.getElementById("dati_istat_text");
    eta_table = document.getElementById("tr_tbl_eta");
    tr_template = document.getElementById("tr_template");
    fetchEtaBetween(0,100);
});

function updateText(min, max){
    find_ISTAT_text.innerText = find_ISTAT_text.dataset.prefix + min + "-" + max +  find_ISTAT_text.dataset.suffix;
}

function fetchEtaBetween(min, max){
	
    const betweenApiURL = "/etaData";
    const encodedQuery = `?min=${encodeURIComponent(min)}&max=${encodeURIComponent(max)}`;
    
    fetch(apiBaseURL+betweenApiURL+encodedQuery)
		.then(req=>req.json())
		.then(json=>{
            eta_table.innerHTML = '';

            for(const eta_data of json){

                let row = tr_template.replace('{{eta}}',eta_data.eta)
                    .replace('{{maschi}}',eta_data.maschi)
                    .replace('{{femmine}}',eta_data.femmine)
                    .replace('{{%maschi}}',100*eta_data.maschi/eta_data.totale)
                    .replace('{{%femmine}}',100*eta_data.femmine/eta_data.totale)
                    .replace('{{totale}}',eta_data.totale)
            }

            let output = '<select class="form-control" id="tendina" onchange="selezionaProvincia()">';
            for (const comune of comuni) {
                output += `<option data-comune_id="${comune.id}">${comune.comune}</option>`;
            }
            output += '</select>';
            
            SX.innerHTML = output;
            
        });


	updateText(min,max)
}