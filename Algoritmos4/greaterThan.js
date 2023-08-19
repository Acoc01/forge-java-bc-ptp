function greatherThan(x,y){
    var cont = 0;
    for(var i = 0; i < x.length; ++i){
        if(x[i] > y) cont++;
    }
    return cont;
}

res = greatherThan([1,2,3,4,5,6],3);
console.log(res);