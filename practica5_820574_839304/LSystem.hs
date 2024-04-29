module LSystem where

import Turtle
import Data.Char


--plot, secuencia de puntos [(0,0) (0,1) (0,1) (1,1) (1,1) (1,0) (1,0) (0,0) (0,0)] la funcion polyline de SVG.hsr recibe esta lista generada por plot
-- dividir trabajo en dos: una lista y una funcion para tratar cada caracter por separado (?)


-- caso base: el string tiene 0 caracteres = devuelve la posicion de la tortuga (sin cambios)
-- caso recursivo: coge la cabeza del string y devuelve la posicion de la tortuga
                  --  concatenada con tplot sin el primer caracter del String y con la
                  --  posicion de la tortuga modificada

tplot :: Turtle -> String -> [Position]
tplot turtle [] = [(\(_, _, p, _) -> p) turtle]  -- caso base
tplot turtle (x:xs) = if (isLower x) then (\(_, _, p, _) -> p) turtle : tplot turtle xs
                                     else (\(_, _, p, _) -> p) turtle : tplot (moveTurtle turtle (charToMove x)) xs
-- caso recursivo: coge la cabeza del string y devuelve la posicion de la tortuga


-- charToMove: recibe un caracter y devuelve un movimiento (o Nothing)
charToMove :: Char -> Move
charToMove '>' = Forward
charToMove '+' = TurnRight
charToMove '-' = TurnLeft
charToMove c = Forward
-- charToMove _   = error "Comando desconocido"



--------------------- PARTE 2 ---------------------

rulesKoch :: Char -> String
rulesKoch 'F' = "F+F--F+F"
rulesKoch c = [c]


rulesKochSquare :: Char -> String
rulesKochSquare 'F' = "F+F-F-F+F"
rulesKochSquare c = [c]


rulesKochSnowflake :: Char -> String
rulesKochSnowflake 'F' = "F-F++F-F"
rulesKochSnowflake c = [c]


rulesMinkowski :: Char -> String
rulesMinkowski 'F' = "F+F-F-FF+F+F-F"
rulesMinkowski c = [c]


rulesArrowhead :: Char -> String
rulesArrowhead 'F' = "G-F-G"
rulesArrowhead 'G' = "F+G+F"
rulesArrowhead c = [c]   --una cadena de caracteres es equivalente a un String


rulesHilbert :: Char -> String
rulesHilbert 'f' = "-g>+f>f+>g-"
rulesHilbert 'g' = "+f>-g>g->f+"
rulesHilbert c = [c]


rulesGosper :: Char -> String
rulesGosper 'F' = "F-G--G+F++FF+G-"
rulesGosper 'G' = "+F-GG--G-F++F+G"
rulesGosper c = [c]






rulifyOnce :: (Char -> String) -> String -> String
rulifyOnce rules [] = []
rulifyOnce rules (x:xs) = (rules x) ++ (rulifyOnce rules xs)

lsystem :: (Char -> String) -> String -> Int -> String
lsystem rules string 0 = string
lsystem rules string i = lsystem rules (rulifyOnce rules string) (i-1)