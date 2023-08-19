function eraseBetweenIdx(x,l,r){
    var res = [];
    for(var i = 0; i < x.length; ++i){
        if(i < l || i > r) res.push(x[i]);
    }
    return res;
}

x = [20,30,40,50,60,70]

x = eraseBetweenIdx(x,2,4);

console.log(x);