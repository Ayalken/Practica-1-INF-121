class Celular:
    def __init__(self, nro_telf: str, dueño: str, espacio: int, ram: int, nro_app: int):
        self.nro_telf = nro_telf
        self.dueño = dueño
        self.espacio = espacio
        self.ram = ram
        self.nro_app = nro_app

    def mostrar_datos(self):
        print(f"Número de teléfono: {self.nro_telf}")
        print(f"Nombre del dueño: {self.dueño}")
        print(f"Espacio: {self.espacio} GB")
        print(f"RAM: {self.ram} GB")
        print(f"Número de apps: {self.nro_app}")

    # Sobrecarga del operador + para simular ++ (aumenta nro_app)
    def __add__(self, valor: int):
        self.nro_app += valor
        return self

    # Sobrecarga del operador - para simular -- (disminuye espacio)
    def __sub__(self, valor: int):
        self.espacio -= valor
        if self.espacio < 0:
            self.espacio = 0
        return self

c1 = Celular("12345678", "Javier", 64, 4, 12)
print("+++ Datos antes del cambio +++")
c1.mostrar_datos()

c1 + 10      
c1 - 5       

print("\n+++ Datos después de los operadores +++")
c1.mostrar_datos()
