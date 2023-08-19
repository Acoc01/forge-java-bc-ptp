function returnOddArray(){
    oddArray = [];
    for(var i = 1; i <= 255; ++i){
        if(i % 2 != 0)
            oddArray.push(i);
    }
    return oddArray;
}
y = returnOddArray();
console.log(y); // should log [1,3,5,...,253,255]