function operations(x){
    var min = x[0];
    var max = x[0];
    var sum = 0;
    for(var i = 0; i < x.length; ++i){
        if(x[i] < min)min = x[i];
        if(x[i] > max) max = x[i];
        sum+=x[i]
    }
    return [max,min,sum/x.length];
}

x = [1,2,3,4,5]

console.log(operations(x))