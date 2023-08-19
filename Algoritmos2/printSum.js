function printSum(x){
    var sum = 0;
    for(let i = 0; i <= x; ++i){
        sum+=i;
        console.log(sum);
    }
    return sum;
}

y = printSum(255);
console.log(y);