from multimethod import multimethod

class Videojuego:
    def __init__(self, nombre="", plataforma="", cantidadDeJugadores=0):
        self.nombre = nombre
        self.plataforma = plataforma
        self.cantidadDeJugadores = cantidadDeJugadores

    # Sobrecarga sin parámetros
    @multimethod
    def agregarJugadores(self):
        self.cantidadDeJugadores += 1

    # Sobrecarga con parámetro int
    @multimethod
    def agregarJugadores(self, cantidad: int):
        self.cantidadDeJugadores += cantidad

v1 = Videojuego("Minecraft", "PC")
v2 = Videojuego("FIFA 25", "PS5", 1)

print(f"Videojuego 1: {v1.nombre}-{v1.plataforma} - Jugadores: {v1.cantidadDeJugadores}")
print(f"Videojuego 2: {v2.nombre}-{v2.plataforma} - Jugadores: {v2.cantidadDeJugadores}")

v1.agregarJugadores()
print(f"Después de agregar un jugador a {v1.nombre}: {v1.cantidadDeJugadores}")

cantidad = int(input(f"¿Cuántos jugadores quieres añadir a {v2.nombre}? "))
v2.agregarJugadores(cantidad)

print("\nResultado final")
print(f"Videojuego 1: {v1.nombre}-{v1.plataforma} - Jugadores: {v1.cantidadDeJugadores}")
print(f"Videojuego 2: {v2.nombre}-{v2.plataforma} - Jugadores: {v2.cantidadDeJugadores}")
