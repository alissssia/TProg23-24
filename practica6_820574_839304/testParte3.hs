import BinaryTree

main = do
    let tVacio = (empty::Tree Int)
        t1 = (tree 1 (tree 2 (leaf 3) empty) (tree 5 empty empty))
        t2 = (tree "R" (tree "HI" (leaf "A") (leaf "NID")) (tree "HD" empty (leaf "NDD")))
    

    putStrLn "======================================"
    putStrLn ""

    putStrLn "TEST buildBalanced []:"
    print (buildBalanced ([]::[Int]))
    putStrLn ""

    putStrLn "TEST buildBalanced [3]:"
    print (buildBalanced [3])
    putStrLn ""

    putStrLn "TEST buildBalanced [1..6]:"
    print (buildBalanced [1..6])
    putStrLn ""

    putStrLn "TEST buildBalanced [3,3,3,3,3]:"
    print (buildBalanced [3,3,3,3,3])
    putStrLn ""

    putStrLn "TEST buildBalanced [1,5,5,5,9]:"
    print (buildBalanced [1,5,5,5,9])
    putStrLn ""


