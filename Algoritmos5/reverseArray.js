function reverse(x){
    var l = 0, r = x.length-1;
    var aux = x[l];
    while(l < r){
        console.log(l+' '+r)
        aux = x[l];
        x[l] = x[r];
        console.log(aux + ' ' + x[r])
        x[r] = aux;
        l++; r--;
    }
}
x = [1,2,3,4]
reverse(x)
console.log(x);