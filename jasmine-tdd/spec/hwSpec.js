//Devuelve la suma de 1 a N. Por ejemplo,  Sum1toN(3) devolverá la suma de 1+2+3, la cual es 6
//sum1toN(255) devuelve la suma de todos los números de 1 a 255
function Sum1toN(n){
    var sum = 0;
    var i = 1;
    while(i <= n){
        sum+=i;
        i++;
    }
    return sum;
}
//devuelve la suma del primer y último número en el array
function sumFirstLast(arr){
    if(arr.length < 2)
        return false;
    return arr[0]+arr[arr.length-1];
}

// Devuelve la suma del minimo y maximo del array

function sumMaxMin(arr){
    if(arr.length == 1){
        return arr[0];
    }else if(arr.length == 2){
        return (arr[0]+arr[1]);
    }else if(arr.length <= 0){
        return undefined;
    }
    var max = arr[0];
    var min = arr[0];
    var l = 0, r = arr.length;

    while(l < r){
        if(arr[l] > max) max = arr[l];
        if(arr[l] < min) min = arr[l];
        if(arr[r] > max) max = arr[r];
        if(arr[r] < min) min = arr[r];
        r--;l++;
    }
    return max+min;
}
    
describe("Sum1toN", function() { 
    it("should return 3 when we pass 2 as an argument", function() { 
        expect(Sum1toN(2)).toEqual(3); 
    }); 
    it("should return 6 when we pass 3 as an argument", function() { 
        expect(Sum1toN(3)).toEqual(6); 
    }); 
    it("should return 10 when we pass 4 as an argument", function() { 
        expect(Sum1toN(4)).toEqual(10); 
    });
    it("should return 0 when we pass 0 as an argument", function(){
        expect(Sum1toN(0)).toEqual(0);
    })
});
    
describe("sumFirstLast", function() { 
    it("should return 3 when we pass [1,2] as an argument", function() { 
        expect(sumFirstLast([1,2])).toEqual(3); 
    }); 
    it("should return 10 when we pass [2,3,8] as an argument", function() { 
        expect(sumFirstLast([2,3,8])).toEqual(10); 
    }); 
    it("should return -10 when we pass [-6,23,3,-4] as an argument", function() { 
        expect(sumFirstLast([-6,23,3,-4])).toEqual(-10); 
    }); 
    it("should return null when we pass [1] as an argument", function(){
        expect(sumFirstLast([1])).toEqual(false);
    })
});

describe("sumMaxMin", function() {
    it("should return 0 when we pass [-1,-1,-1,1] as an argument", function(){
        expect(sumMaxMin([-1,-1,-1,1])).toEqual(0);
    });
    it("should return undefined when we pass [] as an argument", function(){
        expect(sumMaxMin([])).toEqual(undefined);
    });
    it("should return 2 when we pass [1,1,1,1,1] as an argument", function(){
        expect(sumMaxMin([1,1,1,1,1])).toEqual(2);
    });
    it("should return 1 when we pas [1] as an argument", function(){
        expect(sumMaxMin([1])).toEqual(1);
    });
    it("should return 6 when we pass [1,2,3,4,5] as an argument", function(){
        expect(sumMaxMin([1,2,3,4,5])).toEqual(6);
    });
})