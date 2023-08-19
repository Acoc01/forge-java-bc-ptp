function from1to255(){
    //255-> console.log(255) -> 255-1 = 254
    //254 -> ...
    //1 -> console.log(1) -> 1-1 = 0
    //¿i > 0? 0 > 0 == false.
    for(var i = 255; i > 0; i--){
        console.log(i);
    }
}

from1to255();