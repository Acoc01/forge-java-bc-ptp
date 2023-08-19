function odds(){
    for(var i = 0; i < 1001; i+=2)
        console.log(i);
}

function resto(){
    for(var i = 0; i < 1001; ++i){
        if(i % 2 == 0)
            console.log(i);
    }
}

// odds();
resto();