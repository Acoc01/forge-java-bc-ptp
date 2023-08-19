function sigma(n){
    var sum = 0;
    var i = 1;
    while(i != n+1){
        sum+=i;
        i++;
    }
    return sum;
}

console.log(sigma(5))