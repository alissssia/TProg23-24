
data Era = BBY | ABY deriving (Show, Ord, Eq)

data Nacimiento = Nacimiento {
    anyo :: Word, -- se usa Word y no Int para que no se puedan ingresar años negativos
    era :: Era
} deriving (Show, Eq)

-- si se devuelve GT, la primera fecha es mayor que la segunda, es decir la primera fecha es más reciente
instance Ord Nacimiento where
    compare (Nacimiento anyo1 era1) (Nacimiento anyo2 era2)
        | era1 == era2 = case era1 of
            ABY -> compare anyo1 anyo2
            BBY -> compare anyo2 anyo1
        | era1 == BBY = LT -- BBY < ABY la fecha es menor asi que el personaje es mas mayor
        | era1 == ABY = GT -- ABY > BBY la fecha es mayor asi que el personaje es mas joven


data Personaje = Personaje {
    nombre :: String,
    nacimiento :: Nacimiento
} deriving (Show, Eq)

instance Ord Personaje where
    compare (Personaje _ nacimiento1) (Personaje _ nacimiento2) = compare nacimiento1 nacimiento2

--segunda parte SIN PROBAR
data ArbolFamiliar = ArbolFamiliar {
    personaje :: Personaje,
    hijos :: [ArbolFamiliar]
} deriving (Show, Ord, Eq)

youngest :: ArbolFamiliar -> Personaje
youngest (ArbolFamiliar personaje hijos) = 
    let
        hijosYoungest = map youngest hijos
        hijosYoungestSorted = sort hijosYoungest
    in
        if null hijosYoungestSorted then personaje else youngest (head hijosYoungestSorted)

-- FIN DE LA PARTE SIN PROBAR

main = do
    let luke = Personaje "Luke Skywalker" (Nacimiento 19 BBY)
    let leia = Personaje "Leia Organa" (Nacimiento 19 BBY)
    let anakin = Personaje "Anakin Skywalker" (Nacimiento 41 BBY)
    let hola = Personaje "Hola" (Nacimiento 41 ABY)
    let joven = Personaje "Joven" (Nacimiento 80 ABY)
    let viejo = Personaje "Viejo" (Nacimiento 300 BBY)
   
    putStrLn $ "Nacimiento de Luke: " ++ show (nacimiento luke)
    putStrLn $ "Nacimiento de Leia: " ++ show (nacimiento leia)
    putStrLn $ "Nacimiento de Anakin: " ++ show (nacimiento anakin)
    putStrLn $ "Anakin es mayor que Luke: " ++ show (anakin < luke) -- la fecha de nacimiento de anakin es menor que la de luke
    putStrLn $ "Hola es menor que Luke: " ++ show (hola > luke) -- la fecha de nacimiento de hola es mayor que la de luke
    putStrLn $ "Viejo es mayor que Luke (true significa que la fecha de viejo es menor que la de luke): " ++ show (viejo < luke) -- la fecha de nacimiento de viejo es menor que la de luke
    putStrLn $ "Viejo no es mas joven que Leia (false significa que la fecha de viejo no es mayor que la de leia): " ++ show (viejo > leia) -- la fecha de nacimiento de viejo no es mayor que la de leia
    putStrLn $ "Joven es mas joven que hola (true significa que la fecha de joven es mayor que la de hola): " ++ show (joven > hola) -- la fecha de nacimiento de joven es menor que la de hola