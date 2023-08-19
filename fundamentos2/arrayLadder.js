function ladder(arr,y){
    var i = 0;
    while(i < arr.length){
        arr[i++]*=y;
    }
    return arr;
}

x = [1,2,3,4]
y = 3;
console.log(ladder(x,y))