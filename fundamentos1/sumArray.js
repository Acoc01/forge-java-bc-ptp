function sum(x){
    var sum = 0;
    for(var i = 0; i < x.length; ++i){
        sum+=x[i]
    }
    return sum;
}

all = sum([1,2,3,4,5])
console.log(all);