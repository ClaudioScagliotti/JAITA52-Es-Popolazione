/* 
    remove the text part of eta so that i can easily convert the
    field afterwards to a tinyint instead
*/
update popolazione_italiana_eta
    set eta = REPLACE(REPLACE(REPLACE(eta, 'anni', ''),' ',''),'epiù','');

/*
    change the field from varchar to tinyint
*/
alter table popolazione_italiana_eta
    modify eta tinyint;