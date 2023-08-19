function fibonacci(n){
    var arr = [0,1]
    if(n == 1){
        return arr[0];
    }else if(n == 2){
        return arr[1];
    }
    for(var i = 1; i < n;++i){
        arr.push(arr[i-1] + arr[i]);
    }
    return arr[n];
}

console.log(fibonacci(1))
console.log(fibonacci(2))
console.log(fibonacci(3))
console.log(fibonacci(4))