function toTheLeft(x){
    var aux = x[x.length-1];
    for(var i = x.length-1; i > 0; --i){
        var aux2 = x[i-1];
        x[i-1] = aux;
        aux = aux2;
    }
    x[x.length-1] = 0;
}

x = [1,2,3,4];
toTheLeft(x)
console.log(x)