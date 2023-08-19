function replaceNegatives(x){
    for(var i = 0; i < x.length; ++i){
        if(x[i] < 0) x[i] = 0;
    }
}

x = [-1,-2,3,4]

replaceNegatives(x)

console.log(x);