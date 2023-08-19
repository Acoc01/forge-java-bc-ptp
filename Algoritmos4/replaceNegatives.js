function replaceNegatives(x){
    for(var i = 0; i < x.length; ++i){
        if(x[i] < 0)x[i] = 'Dojo'
    }
}
x = [-1,2,3,4,-5];
replaceNegatives(x)
console.log(x)