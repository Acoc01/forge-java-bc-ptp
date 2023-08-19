function evenodds(x){
    var cont = 0;
    var flag = false;
    var i = 0;
    while(i < x.length){
        if(x[i] % 2 == 0){
            if(flag){
                cont = 0;
                flag = false;
            }
            cont++;
            if(cont == 3)
                console.log('¡Es para bien!')
        }else{
            if(!flag){
                cont = 0;
                flag = true;
            }
            cont++;
            if(cont == 3)
                console.log('¡Que imparcial!')
        }
        i++;
    }
}