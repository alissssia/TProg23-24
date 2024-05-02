split :: [Int] -> ([Int],Int,[Int])
split [] = ([],0,[])
split xs =  (xa,b,xb)
    where   l = (div (length xs) 2)
            (xa,(b:xb)) = (splitAt l xs)

main = do
    let listaPar = [1,2,3,4,5,6]
        listaImpar = [1,2,3,4,5,6,7]
        (ap,ep,bp) = (split listaPar)
        (ai,ei,bi) = (split listaImpar)

    putStrLn $ "Calculando [1,2,3,4,5,6]"
    print ap
    print ep
    print bp
    putStrLn ""
    putStrLn $ "Calculando [1,2,3,4,5,6,7]"
    print ai
    print ei
    print bi