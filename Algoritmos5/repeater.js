function repeater(x){
    var aux = [];
    for(var i = 0; i < x.length; ++i){
        aux.push(x[i])
        aux.push(x[i]);
    }
    return aux;
}
x = [1,2,3,4]
x = repeater(x)
console.log(x);