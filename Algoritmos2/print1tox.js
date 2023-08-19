function printUpTo(x){
    if(x >= 1 && x <= 1000)
        for(let i = 1; i <=x; ++i)
            console.log(i);
    else
        return false;
}
printUpTo(1000)
y = printUpTo(-10)
console.log(y)