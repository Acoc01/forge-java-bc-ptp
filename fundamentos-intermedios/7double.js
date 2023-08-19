function double(arr){
    var temp = [];
    for(var i = 0; i < arr.length; ++i){
        temp.push(arr[i])
        temp.push(arr[i])
    }
    return temp;
}

arr = [1,2,3,4,5];
console.log(double(arr));