Module LSystem where
import Turtle


-- falta implementar
-- caso base: el string tiene 0 caracteres = devuelve la posicion de la tortuga (sin cambios)
-- caso recursivo: coge la cabeza del string y devuelve la posicion de la tortuga
                    concatenada con tplot sin el primer caracter del String y con la
                    posicion de la tortuga modificada

tplot :: Turtle -> String -> [Position]


--plot, secuencia de puntos [(0,0) (0,1) (0,1) (1,1) (1,1) (1,0) (1,0) (0,0) (0,0)] la funcion polyline de SVG.hsr recibe esta lista generada por plot
-- dividir trabajo en dos: una lista y una funcion para tratar cada caracter por separado (?)