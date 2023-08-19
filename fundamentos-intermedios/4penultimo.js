function penultimo(arr){
    if(arr.length < 3){
        return null
    }else{
        return arr[arr.length-2];
    }
}

console.log(penultimo([42,true,4,"Liam",7]))