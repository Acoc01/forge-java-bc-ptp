function largestElement(x){
    var aux = 0;
    for(let i = 0; i < x.length; ++i)
        x[i] > aux ? aux = x[i] : aux = aux;
    return aux;
}
console.log(largestElement([4,3,20,19,5]));
