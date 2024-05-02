module BinaryTree where

import Data.List

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
            



----------------  PARTE 2 ----------------

add :: (Ord t) => Tree t -> t -> Tree t
add Empty e = Leaf e
add (Leaf t) e = if (e < t) then (BuildTree t (Leaf e) Empty)
                            else (BuildTree t Empty (Leaf e))
add (BuildTree t it dt) e = if (e < t)  then (BuildTree t (add it e) dt)
                                        else (BuildTree t it (add dt e))


build :: (Ord t) => [t] -> Tree t
build [] = empty
build ts = (buildOnce empty ts)
    where   buildOnce :: (Ord t) => Tree t -> [t] -> Tree t
            buildOnce t [] = t
            buildOnce t (x:ts) = buildOnce (add t x) ts


buildBalanced :: (Ord t) => [t] -> Tree t
buildBalanced [] = empty
buildBalanced [ts] = Leaf ts
buildBalanced ts = (BuildTree te (buildBalanced ta) (buildBalanced tb))
    where
        sorted = (sort ts)
        (ta,te,tb) = (split sorted)
            where
                split :: (Ord t) => [t] -> ([t],t,[t])
                split xs = (moveRepeats(xa,b,xb))
                    where
                        l = (div (length xs) 2)
                        (xa,(b:xb)) = (splitAt l xs)
                        moveRepeats :: (Ord t) => ([t],t,[t]) -> ([t],t,[t])
                        moveRepeats ([],e,b) = ([],e,b)
                        moveRepeats (as,e,bs) = if ((last as) == e) then (moveRepeats ((init as),e,e:bs))
                                                                        else (as,e,bs)

                
                
