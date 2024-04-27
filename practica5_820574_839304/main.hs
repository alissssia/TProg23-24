import SVG
import LSystem

-- funciones para probar que la practica funciona

main = do
-- dibuja un cuadrado
--    let cuadrado = tplot (1, 90, (0,0), 90) ">+>+>+>+"
--    savesvg "cuadrado" cuadrado

-- dibuja un triangulo
--    let triangulo = tplot (1, 120, (0,0), 0) ">+>+>+"
--    savesvg "triangulo" triangulo

-- dibuja un circulo
--    let circulo = tplot (0.1, 10, (0,0), 0) ">+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+"
--    savesvg "circulo" circulo


-- dibuja sierpinsky arrowhead
    let arrowhead1 = tplot (1, 60, (0,0), 0) (lsystem rulesArrowhead "F" 1)
    savesvg "arrowhead1" arrowhead1

    let arrowhead3 = tplot (1, 60, (0,0), 0) (lsystem rulesArrowhead "F" 3)
    savesvg "arrowhead3" arrowhead3

    let arrowhead5 = tplot (1, 60, (0,0), 0) (lsystem rulesArrowhead "F" 5)
    savesvg "arrowhead5" arrowhead5

    let arrowhead8 = tplot (1, 60, (0,0), 0) (lsystem rulesArrowhead "F" 8)
    savesvg "arrowhead8" arrowhead8


-- dibuja hilbert
    let hilbert1 = tplot (1, 90, (0,0), 0) (lsystem rulesHilbert "f" 1)
    savesvg "hilbert1" hilbert1

    let hilbert3 = tplot (1, 90, (0,0), 0) (lsystem rulesHilbert "f" 3)
    savesvg "hilbert3" hilbert3

    let hilbert5 = tplot (1, 90, (0,0), 0) (lsystem rulesHilbert "f" 5)
    savesvg "hilbert5" hilbert5

    let hilbert8 = tplot (1, 90, (0,0), 0) (lsystem rulesHilbert "f" 8)
    savesvg "hilbert8" hilbert8

--    putStrLn $ "lsystem rulesArrowhead \"F\" 0: " ++ show (lsystem rulesArrowhead "F" 0)
--    putStrLn $ "lsystem rulesArrowhead \"F\" 1: " ++ show (lsystem rulesArrowhead "F" 1)
--    putStrLn $ "lsystem rulesArrowhead \"F\" 2: " ++ show (lsystem rulesArrowhead "F" 2)
--    putStrLn $ "lsystem rulesArrowhead \"F\" 3: " ++ show (lsystem rulesArrowhead "F" 3)
