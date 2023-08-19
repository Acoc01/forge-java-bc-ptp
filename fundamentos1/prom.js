function avg(x){
    var sum = 0;
    for(var i = 0; i < x.length; ++i){
        sum+=x[i];
    }
    return sum/x.length;
}


console.log(avg([1,2,3,4,5]));