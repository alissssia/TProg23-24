module Main where

import Data.String

data Tree t = BuildTree t (Tree t) (Tree t) | Leaf t | Empty

empty :: Tree t
empty = Empty

leaf :: t -> Tree t
leaf t = Leaf t

tree :: t -> Tree t -> Tree t-> Tree t
tree t it dt = BuildTree t it dt

size :: Tree t -> Int
size Empty = 0
size (Leaf t) = 1
size (BuildTree t it dt) = 1 + (size it) + (size dt)

tab :: Int -> String
tab 0 = ""
tab 1 = " \\_"
tab n = "   " ++ (tab (n-1))

instance (Show t) => Show (Tree t) where
    show t = showTabbed 0 t
        where
            showTabbed :: Int -> Tree t -> String
            showTabbed i Empty = (tab i) ++ "()\n"
            showTabbed i (Leaf t) = (tab i) ++ (show t) ++ "\n"
            showTabbed i (BuildTree t it dt) = (tab i)++(show t)++"\n"++(showTabbed (i+1) it)++(showTabbed (i+1) dt)

main :: IO ()
main = do
    let tVacio = (empty::Tree ())
        t1 = (tree 1 (tree 2 (leaf 3) (leaf 4)) (tree 5 empty (leaf 6)))
        t2 = (tree "R" (tree "HI" (leaf "NII") (leaf "NID")) (tree "HD" (leaf "NDI") (leaf "NDD")))
    
    putStrLn ""
    putStrLn "======================================"
    putStrLn " Árbol vacío:"
    putStrLn "-------------"
    putStrLn $ show tVacio
    putStrLn $ "size: " ++ show (size tVacio)
    putStrLn "======================================"

    putStrLn "Árbol test 1:"
    putStrLn "-------------"
    putStrLn $ show t1
    putStrLn $ "size: " ++ show (size t1)
    putStrLn "======================================"

    
    putStrLn "Árbol test 2:"
    putStrLn "-------------"
    putStrLn $ show t2
    putStrLn $ "size: " ++ show (size t2)
    putStrLn "======================================"
