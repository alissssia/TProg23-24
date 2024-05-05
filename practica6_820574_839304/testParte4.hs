import BinaryTree

main = do
    let tVacio = (empty::Tree Int)
        t1 = (tree 1 (tree 2 (leaf 3) (leaf 4)) (tree 5 empty (leaf 6)))
        t2 = (tree "R" (tree "HI" (leaf "NII") (leaf "NID")) (tree "HD" (leaf "NDI") (leaf "NDD")))
    
    putStrLn "======================================"
    putStrLn ""
    putStrLn "TEST VACIO:"
    print tVacio
    putStrLn ""

    putStrLn "TEST preorder VACIO:"
    print (preorder tVacio)
    putStrLn ""

    putStrLn "TEST inorder VACIO:"
    print (inorder tVacio)
    putStrLn ""


    putStrLn "TEST postorder VACIO:"
    print (postorder tVacio)
    putStrLn ""

    putStrLn "TEST balance TEST VACIO:"
    print (balance tVacio)
    putStrLn ""

    putStrLn "======================================"
    putStrLn ""
    putStrLn "TEST 1 BASE:"
    print t1
    putStrLn ""

    putStrLn "TEST preorder TEST 1:"
    print (preorder t1)
    putStrLn ""

    putStrLn "TEST inorder TEST 1:"
    print (inorder t1)
    putStrLn ""

    putStrLn "TEST postorder TEST 1:"
    print (postorder t1)
    putStrLn ""

    putStrLn "TEST balance TEST 1:"
    print (balance t1)
    putStrLn ""

    putStrLn "======================================"
    putStrLn ""
    putStrLn "TEST 2 BASE:"
    print t2
    putStrLn ""

    putStrLn "TEST preorder TEST 2:"
    print (preorder t2)
    putStrLn ""

    putStrLn "TEST inorder TEST 2:"
    print (inorder t2)
    putStrLn ""

    putStrLn "TEST postorder TEST 2:"
    print (postorder t2)
    putStrLn ""

    putStrLn "TEST balance TEST 2:"
    print (balance t2)
    putStrLn ""

    putStrLn "======================================"

    let tNombres = build ["Adolfo", "Diego", "Juan", "Pedro", "Tomas"]

    putStrLn ""
    putStrLn "TEST NOMBRES BASE:"
    print tNombres
    putStrLn ""

    putStrLn "TEST balance NOMBRES:"
    print (balance tNombres)
    putStrLn ""

    putStrLn "======================================"

    let tNumeros = build [1,5,5,5,9]

    putStrLn ""
    putStrLn "TEST NUMEROS BASE:"
    print tNumeros
    putStrLn ""

    putStrLn "TEST balance NUMEROS:"
    print (balance tNumeros)
    putStrLn ""