function hungry(arr){
    var i = 0;
    var flag = false;
    while(i < arr.length){
        if(arr[i++] == "comida"){
            console.log('Yummy')
            flag = true;
        }
    }
    if(!flag)
        console.log("Tengo hambre");
}