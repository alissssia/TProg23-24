main = do
    let listaPar = [1,2,3,4,5,6]
        listaImpar = [1,2,3,4,5,6,7]
        lp = (div (length listaPar) 2)
        li = (div (length listaImpar) 2)
        (ap,bp) = (splitAt lp listaPar)
        (ai,bi) = (splitAt li listaImpar)

    print lp
    print li
    print ap
    print bp
    print ai
    print bi
    print (head bp)
    print (head bi)

