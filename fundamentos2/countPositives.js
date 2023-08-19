function replace(x){
    var i = 0;
    var cont = 0;
    while(i < x.length)
        if(x[i++] > 0)
            cont++;
    x[x.length-1] = cont;
}
