function odds(){
    var temp = [];
    for(var i = 1; i <= 50; ++i){
        if(i%2!=0)temp.push(i);
    }
    return temp;
}

console.log(odds());