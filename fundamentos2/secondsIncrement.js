function increment(arr){
    var i = 0;
    var len = arr.length;

    while(i < len){
        if(arr[i] % 2 != 0)
            arr[i]++;
        i++;
    }

    i = 0;
    while(i < len){
        console.log(arr[i++])
    }
    return arr;
}