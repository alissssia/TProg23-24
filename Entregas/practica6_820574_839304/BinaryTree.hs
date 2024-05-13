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


----------------  PARTE 3 ----------------

buildBalanced :: (Ord t) => [t] -> Tree t
buildBalanced [] = empty
buildBalanced [ts] = leaf ts
buildBalanced ts = (BuildTree te (buildBalanced ta) (buildBalanced tb))
    where
        sorted = (sort ts)
        l = (div (length sorted) 2)
        te = sorted!!l -- obtenemos el elemento que hay a la mitad
        ta = (takeWhile (/= te) sorted) -- arbol izquierdo de elementos estrictamente menores que elemento central
        tb = (drop 1 (dropWhile (< te) sorted)) -- arbol derecho de elementos igual o mayores que elemento central
            -- quitamos el elemento central (situado en la primera posición) porque ya lo tenemos en 'te'
            

----------------  PARTE 4 ----------------

preorder :: Tree t -> [t]
preorder Empty = []
preorder (Leaf t) = [t]
preorder (BuildTree t it dt) = [t] ++ (preorder it) ++ (preorder dt)
                
postorder :: Tree t -> [t]
postorder Empty = []
postorder (Leaf t) = [t]
postorder (BuildTree t it dt) = (postorder it) ++ (postorder dt) ++ [t]

inorder :: Tree t -> [t]
inorder Empty = []
inorder (Leaf t) = [t]
inorder (BuildTree t it dt) = (inorder it) ++ [t] ++ (inorder dt)


balance :: (Ord t) => Tree t -> Tree t
balance t = (buildBalanced (inorder t))


----------------  PARTE 5 ----------------

between :: (Ord t) => Tree t -> t -> t -> [t]
between t xmin xmax = (betweenOrdered (balance t) xmin xmax)
    where
        betweenOrdered :: (Ord t) => Tree t -> t -> t -> [t]
        betweenOrdered Empty _ _ = []
        betweenOrdered (Leaf t) xmin xmax = if (t >= xmin && t <= xmax) then [t]
                                                                 else []
        betweenOrdered (BuildTree t it dt) xmin xmax = if (res == 0) then (sort ([t] ++ (betweenOrdered it xmin xmax) ++ (betweenOrdered dt xmin xmax))) -- si raíz está en el rango, buscamos en ambos lados
                                        else if (res == -1) then (sort (betweenOrdered dt xmin xmax))                              -- si raíz no llega al rango, buscamos solo por la derecha (hijos izquierdos serán todavía menores)
                                        else (sort (betweenOrdered it xmin xmax))                                                  -- si raíz se pasa del rango, buscamos solo por la izquierda (hijos derechos serán igual o mayores)
            where
                contains :: (Ord t) => t -> t -> t -> Int
                contains t xmin xmax = if (t >= xmin && t <= xmax) then 0   -- si entra en el rango, 0
                                    else if (t < xmin) then -1           -- si no llega al rango, -1
                                    else 1                               -- si se pasa del rango, 1
                res = (contains t xmin xmax)