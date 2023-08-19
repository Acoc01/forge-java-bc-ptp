function greaterThan(x,y){
    var cont = 0;
    for(var i = 0; i < x.length; ++i){
        if(x[i] > y) cont++;
    }
    return cont;
}


console.log(greaterThan([1,2,3,4,5],3))