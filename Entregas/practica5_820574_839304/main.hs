import SVG
import LSystem

-- funciones para probar que la practica funciona

main = do
-- dibuja un cuadrado
    let cuadrado = tplot (1, 90, (0,0), 90) ">+>+>+>+"
    savesvg "cuadrado" cuadrado

-- dibuja un triangulo
    let triangulo = tplot (1, 120, (0,0), 0) ">+>+>+"
    savesvg "triangulo" triangulo

-- dibuja un circulo
    let circulo = tplot (0.1, 10, (0,0), 0) ">+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+>+"
    savesvg "circulo" circulo


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

-- dibuja Koch
    let koch1 = tplot (1, 60, (0,0), 0) (lsystem rulesKoch "F" 1)
    savesvg "koch1" koch1

    let koch3 = tplot (1, 60, (0,0), 0) (lsystem rulesKoch "F" 3)
    savesvg "koch3" koch3

    let koch5 = tplot (1, 60, (0,0), 0) (lsystem rulesKoch "F" 5)
    savesvg "koch5" koch5

--dibuja Koch Square
    let kochSquare1 = tplot (1, 90, (0,0), 0) (lsystem rulesKochSquare "F" 1)
    savesvg "kochSquare1" kochSquare1

    let kochSquare3 = tplot (1, 90, (0,0), 0) (lsystem rulesKochSquare "F" 3)
    savesvg "kochSquare3" kochSquare3

    let kochSquare5 = tplot (1, 90, (0,0), 0) (lsystem rulesKochSquare "F" 5)
    savesvg "kochSquare5" kochSquare5

--dibuja Koch Snowflake
    let kochSnowflake1 = tplot (1, 60, (0,0), 0) (lsystem rulesKochSnowflake "F++F++F" 1)
    savesvg "kochSnowflake1" kochSnowflake1

    let kochSnowflake3 = tplot (1, 60, (0,0), 0) (lsystem rulesKochSnowflake "F++F++F" 3)
    savesvg "kochSnowflake3" kochSnowflake3

    let kochSnowflake5 = tplot (1, 60, (0,0), 0) (lsystem rulesKochSnowflake "F++F++F" 5)
    savesvg "kochSnowflake5" kochSnowflake5

--dibuja Minkowski
    let minkowski1 = tplot (1, 90, (0,0), 0) (lsystem rulesMinkowski "F+F+F+F" 1)
    savesvg "minkowski1" minkowski1

    let minkowski3 = tplot (1, 90, (0,0), 0) (lsystem rulesMinkowski "F+F+F+F" 3)
    savesvg "minkowski3" minkowski3

    let minkowski5 = tplot (1, 90, (0,0), 0) (lsystem rulesMinkowski "F+F+F+F" 5)
    savesvg "minkowski5" minkowski5

--dibuja Gosper
    let gosper1 = tplot (1, 60, (0,0), 0) (lsystem rulesGosper "F" 1)
    savesvg "gosper1" gosper1

    let gosper3 = tplot (1, 60, (0,0), 0) (lsystem rulesGosper "F" 3)
    savesvg "gosper3" gosper3

    let gosper4 = tplot (1, 60, (0,0), 0) (lsystem rulesGosper "F" 4)
    savesvg "gosper4" gosper4

    let gosper5 = tplot (1, 60, (0,0), 0) (lsystem rulesGosper "F" 5)
    savesvg "gosper5" gosper5