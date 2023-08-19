function squares(x){
    for(var i = 0; i < x.length; ++i){
        x[i] *= x[i];
    }
}
x = [1,2,3,4,5]
squares(x)
console.log(x)