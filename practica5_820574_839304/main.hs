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