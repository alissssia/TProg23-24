import BinaryTree

main = do
    let tVacio = (empty::Tree Int)
        t1 = (tree 1 (tree 2 (leaf 3) empty) (tree 5 empty empty))
        t2 = (tree "R" (tree "HI" (leaf "A") (leaf "NID")) (tree "HD" empty (leaf "NDD")))
    
    putStrLn ""
    putStrLn "======================================"
    putStrLn " Add 4 en árbol vacío:"
    putStrLn "-------------"
    print (add tVacio 4)
    putStrLn "======================================"

    putStrLn ""
    putStrLn "TEST 1 BASE:"
    print t1
    putStrLn ""

    putStrLn "-------------"
    putStrLn "Add 0 test 1:"
    putStrLn "-------------"
    print (add t1 0)

    putStrLn "-------------"
    putStrLn ""
    putStrLn "Add 4 test 1:"
    putStrLn "-------------"
    print (add t1 4)

    putStrLn "-------------"
    putStrLn "Add 6 test 1:"
    putStrLn "-------------"
    print (add t1 6)
    putStrLn ""

    putStrLn "-------------"
    putStrLn "Add 7 test 1:"
    putStrLn "-------------"
    print (add t1 7)
    putStrLn ""

    putStrLn "======================================"
    putStrLn ""
    putStrLn "TEST 2 BASE:"
    print t2
    putStrLn ""


    putStrLn "Add \"A\" test 2:"
    putStrLn "-------------"
    print (add t2 "A")

    putStrLn "-------------"
    putStrLn ""
    putStrLn "Add \"ZZZ\" test 2:"
    putStrLn "-------------"
    print (add t2 "ZZZ")
    putStrLn ""

    putStrLn "======================================"
    putStrLn ""
    putStrLn "TEST BUILD [1,2,3,4,5]:"
    print (build [1,2,3,4,5])
    putStrLn ""

    putStrLn "TEST BUILD [5,4,3,2,1]:"
    print (build [5,4,3,2,1])
    putStrLn ""

    putStrLn "TEST BUILD ['c','b','b','d',''e','a']:"
    print (build ['c','b','b','d','e','a'])
    putStrLn ""

    putStrLn "TEST BUILD [3,2,2,4,5,1]:"
    print (build [3,2,2,4,5,1])
    putStrLn ""

    putStrLn "TEST BUILD [3,2,2,5,1,4,4]:"
    print (build [3,2,2,5,1,4,4])
    putStrLn ""


    putStrLn "TEST BUILD []:"
    print (build ([]::[Int]))
    putStrLn ""

    putStrLn "TEST BUILD [3]:"
    print (build [3])
    putStrLn ""

