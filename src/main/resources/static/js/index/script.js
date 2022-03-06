"use strict";

document.addEventListener('DOMContentLoaded', e => {
    let linksButtons = document.querySelectorAll(".index-link");
    linksButtons.forEach(e=>{
        e.addEventListener('click',e=>{
            let link = e.target.dataset.url;
            window.location=link;
        })
    });
});