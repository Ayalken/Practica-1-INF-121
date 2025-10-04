class Mascota:
    def __init__(self, nombre, tipo):
        self.nombre = nombre
        self.tipo = tipo
        self.energia = 50 

    # (a) Alimentar
    def alimentar(self):
        self.energia += 20
        if self.energia > 100:
            self.energia = 100
        print(f"{self.nombre} fue alimentado. Energía: {self.energia}")

    # (b) Jugar
    def jugar(self):
        self.energia -= 15
        if self.energia < 0:
            self.energia = 0
        print(f"{self.nombre} jugó. Energía: {self.energia}")

    # (c) Mostrar datos
    def mostrar(self):
        print(f"Nombre: {self.nombre}, Tipo: {self.tipo}, Energía: {self.energia}")


if __name__ == "__main__":
    m1 = Mascota("Firulais", "Perro")
    m2 = Mascota("Michi", "Gato")

    m1.alimentar()
    m1.jugar()
    m1.mostrar()

    m2.jugar()
    m2.alimentar()
    m2.mostrar()
