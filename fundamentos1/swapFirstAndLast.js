function swap(x){
    var aux = x[0];
    x[0] = x[x.length-1]
    x[x.length-1] = aux;
}

x = [1,2,3,4,5]
swap(x)
console.log(x)