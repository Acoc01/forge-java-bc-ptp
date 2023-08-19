function factorial(n){
    var sum = 1;
    var i = 1;
    while(i != n+1){
        sum*=i;
        i++;
    }
    return sum;
}

console.log(factorial(5))