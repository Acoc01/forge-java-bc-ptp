function second(arr){
    if(arr.length == 1)
        return arr[0];
    if(arr.length == 0)
        return null;
    arr.sort((a,b) => b - a);
    return arr[1];
}

console.log(second([1,2,4,5,7,1,2,1]))