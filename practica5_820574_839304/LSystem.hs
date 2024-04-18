Module LSystem where
    import Turtle
    import SVG

--plot, secuencia de puntos [(0,0) (0,1) (0,1) (1,1) (1,1) (1,0) (1,0) (0,0) (0,0)] la funcion polyline de SVG.hsr recibe esta lista generada por plot
-- dividir trabajo en dos: una lista y una funcion para tratar cada caracter por separado (?)