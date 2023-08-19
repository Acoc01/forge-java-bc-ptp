function nlast(arr,n){
    if(arr.length <= n){
        return null;
    }
    else return arr[n];
}

console.log(nlast([1,2,3,4,5],4))