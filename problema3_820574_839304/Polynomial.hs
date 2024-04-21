-- ghc Polynomial.hs para compilar, ./Polynomial para ejecutar

--Representacion con todos los coeficientes incluyendo 0, se supone que el primer coeficiente es el de mayor grado
data Polynomial = Poly [Double] deriving (Show, Eq)

--Funcion para crear polinomio a partir de lista de coeficientes 
makePoly :: [Double] -> Polynomial
makePoly coeficientes = Poly coeficientes

--Funcion para evaluar polinomio en un punto con el algoritmo de Horner
peval :: Polynomial -> Double -> Double
peval (Poly []) _ = 0
peval (Poly coef) n = foldr (\x y -> x + n*y) 0 coef


--Funcion para calcular la derivada de un polinomio
pderv :: Polynomial -> Polynomial
pderv (Poly coef) = Poly (reverse (zipWith (*) (tail coef) [1..]))



--Funcion para sumar dos polinomios
padd :: Polynomial -> Polynomial -> Polynomial
padd (Poly coef1) (Poly coef2) = Poly (reverse(zipWith (+) coef1 coef2))



-- Función para ejecutar pruebas
main :: IO ()
main = do
    putStrLn "Pruebas de la implementación de polinomios en Haskell:"
    putStrLn "Polinomio 1: 2x^2 + 0x + 1"
    putStrLn "Polinomio 2: 3x^2 + 4x + 1"
    let poly1 = makePoly [1, 0, 2]
        poly2 = makePoly [1, 4, 3]
        point = 2
    putStrLn $ "Evaluación del polinomio 1 en x=" ++ show point ++ ": " ++ show (peval poly1 point)
    putStrLn $ "Evaluación del polinomio 2 en x=" ++ show point ++ ": " ++ show (peval poly2 point)
    putStrLn $ "Suma de polinomios: " ++ show (padd poly1 poly2)
    putStrLn $ "Derivada del polinomio 1: " ++ show (pderv poly1)
    putStrLn $ "Derivada del polinomio 2: " ++ show (pderv poly2)