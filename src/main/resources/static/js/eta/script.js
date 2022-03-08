"use strict";

const apiBaseURL = "api";
let find_ISTAT_text = null;
let eta_table = null;
let tr_template = "";

let min_eta_select = null;
let max_eta_select = null;

document.addEventListener('DOMContentLoaded', event => {
    find_ISTAT_text = document.getElementById("dati_istat_text");
    eta_table = document.getElementById("tr_tbl_eta");
    tr_template = eta_table.innerHTML;
    eta_table.innerHTML='';
    min_eta_select = document.getElementById("min_select");
    min_eta_select.addEventListener('change',onEtaBoundariesChange);
    max_eta_select = document.getElementById("max_select");
    max_eta_select.addEventListener('change',onEtaBoundariesChange);

    document.getElementById("btn_fetch_age_range")
        .addEventListener('click',onBtnFindClick);
    
    fetchEtaBetween(0,100,selectInitializerCb);
});

function tryGetInt(valToConvert,defaultVal){
    let val = parseInt(valToConvert);
    if(!Number.isInteger(val))
        val = defaultVal;
    return val;
}

function onBtnFindClick(event){
	let min = tryGetInt(min_eta_select.value,0);
	let max = tryGetInt(max_eta_select.value,100);
    fetchEtaBetween(min,max);
}

function onEtaBoundariesChange(event){
	let min = tryGetInt(min_eta_select.value,0);
	let max = tryGetInt(max_eta_select.value,100);

	let not_allowed = min>max;
	
	if(not_allowed){	
        alert("selection not allowed, max must be greater than min");

		if(event.currentTarget == min_eta_select){
			min = event.currentTarget.value=0;
		}
		else{
			max = event.currentTarget.value=100;
		}
	}	
}

function updateText(min, max){
    find_ISTAT_text.innerText = find_ISTAT_text.dataset.prefix + min + "-" + max +  find_ISTAT_text.dataset.suffix;
}

function selectInitializerCb(json){
    let eta_template = min_eta_select.innerHTML;
    min_eta_select.innerHTML="";
    max_eta_select.innerHTML="";
    json.forEach(element => {
        min_eta_select.innerHTML+=eta_template.replaceAll('{{eta}}',element.eta);
    });
    max_eta_select.innerHTML = min_eta_select.innerHTML;
}

function fetchEtaBetween(min, max, cb){
	
    const betweenApiURL = "/eta-data";
    const encodedQuery = `?min=${encodeURIComponent(min)}&max=${encodeURIComponent(max)}`;
    
    fetch(apiBaseURL+betweenApiURL+encodedQuery,{method: 'GET'})
		.then(req=>req.json())
		.then(json=>{
            eta_table.innerHTML = '';

            for(const eta_data of json){
                let row = tr_template.replaceAll('{{eta}}',eta_data.eta+' anni')
                    .replaceAll('{{maschi}}',eta_data.maschi)
                    .replaceAll('{{femmine}}',eta_data.femmine)
                    .replaceAll('{{%maschi}}',Math.round(100*eta_data.maschi/eta_data.totale))
                    .replaceAll('{{%femmine}}',Math.round(100*eta_data.femmine/eta_data.totale))
                    .replaceAll('{{totale}}',eta_data.totale);
                eta_table.innerHTML+=row;
            }

            if(cb!=null)
                cb(json);
         })
         /*
        .then(json=>{
       let barM= document.getElementById(bar_maschi);
       let mperc=Math.round(100*eta_data.maschi/eta_data.totale);
       barM.innerHTML=mperc;


        });
        */
	updateText(min,max)

}



