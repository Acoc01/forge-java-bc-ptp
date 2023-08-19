function print(x){
    console.log(x[x.length-2])
    for(var i = 0; i < x.length; ++i){
        if(x[i] % 2 != 0) return x[i];
    } 
}