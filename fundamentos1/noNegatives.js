function replace(x){
    for(var i = 0; i < x.length;++i){
        if(x[i] < 0) x[i] = 0;
    }
}

x = [-1,2,-3,4,5];
replace(x);
console.log(x);