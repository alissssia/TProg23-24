import BinaryTree

main = do
    let tVacio = (empty::Tree ())
        t1 = (tree 1 (tree 2 (leaf 3) (leaf 4)) (tree 5 empty (leaf 6)))
        t2 = (tree "R" (tree "HI" (leaf "NII") (leaf "NID")) (tree "HD" (leaf "NDI") (leaf "NDD")))
    
    putStrLn ""
    putStrLn "======================================"
    putStrLn " Árbol vacío:"
    putStrLn "-------------"
    print tVacio
    putStrLn $ "size: " ++ show (size tVacio)
    putStrLn "======================================"

    putStrLn "Árbol test 1:"
    putStrLn "-------------"
    print t1
    putStrLn $ "size: " ++ show (size t1)
    putStrLn "======================================"

    
    putStrLn "Árbol test 2:"
    putStrLn "-------------"
    print t2
    putStrLn $ "size: " ++ show (size t2)
    putStrLn "======================================"
