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

    putStrLn "TEST entre 1 y 2 VACIO:"
    print (between tVacio 1 2)
    putStrLn ""

    putStrLn "TEST entre 5 y 2 VACIO:"
    print (between tVacio 5 2)
    putStrLn ""

    putStrLn "======================================"
    putStrLn ""
    putStrLn "TEST 1 BASE:"
    print t1
    putStrLn ""

    putStrLn "TEST entre 2 y 5 TEST 1:"
    print (between t1 2 5)
    putStrLn ""

    putStrLn "TEST entre 1 y 6 TEST 1:"
    print (between t1 1 6)
    putStrLn ""

    putStrLn "TEST entre 2 y 3 TEST 1:"
    print (between t1 2 3)
    putStrLn ""

    putStrLn "TEST entre -3 y 8 TEST 1:"
    print (between t1 (-3) 8)
    putStrLn ""

    putStrLn "======================================"
    putStrLn ""
    putStrLn "TEST 2 BASE:"
    print t2
    putStrLn ""

    putStrLn "TEST entre H y N TEST 2:"
    print (between t2 "H" "N")
    putStrLn ""

    putStrLn "TEST entre HI y NII TEST 2:"
    print (between t2 "HI" "NII")
    putStrLn ""

    putStrLn "TEST entre R y ZZZ TEST 2:"
    print (between t2 "R" "ZZZ")
    putStrLn ""

    putStrLn "TEST entre A y ZZZ TEST 2:"
    print (between t2 "A" "ZZZ")
    putStrLn ""

    putStrLn "TEST entre ZZZ y A TEST 2:"
    print (between t2 "ZZZ" "A")
    putStrLn ""

    putStrLn "======================================"