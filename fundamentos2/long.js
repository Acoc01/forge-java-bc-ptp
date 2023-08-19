function replace(x){
    var aux = x[0];
    for (let i = 1; i < x.length; i++) {
        var aux2 = aux.length
        aux = x[i];
        x[i] = aux2;
    }
}
