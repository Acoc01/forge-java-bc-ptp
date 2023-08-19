function max(x){
    var aux = x[0];
    for(var i = 0; i < x.length; ++i){
        if(x[i] > aux) aux = x[i];
    }
    return aux;
}

maxx = max([1,2,3,4]);
console.log(maxx);