function negative(arr){
    var temp = []
    var i = 0;
    while(i < arr.length){
        if(arr[i] > 0)
            temp.push(arr[i] * -1)
        else
            temp.push(arr[i])
        i++;
    }
    return temp;
}