function print(x){
    var min = x[0];
    var max = x[0];
    for(var i = 0; i < x.length; ++i){
        if(x[i] > max) max = x[i];
        if(x[i] < min) min = x[i];
    }
    console.log(min)
    return max;
}