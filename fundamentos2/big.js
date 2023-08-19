function big(x){
    for(var i = 0; i < x.length; ++i){
        if(x[i] >= 0) x[i] = 'big'
    }
}

x = [1,2,3,4]
big(x);
console.log(x)