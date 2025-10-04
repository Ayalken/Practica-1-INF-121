class Bus:
    def __init__(self, asientos):
        self.asientos = asientos
        self.pasajeros = 0
        self.costo = 1.50

    # (a) Subir pasajeros
    def subir_pasajeros(self, cantidad):
        if cantidad <= (self.asientos - self.pasajeros):
            self.pasajeros += cantidad
            print(f"{cantidad} pasajeros subieron al bus.")
        else:
            print("No hay suficientes asientos disponibles.")

    # (b) Cobrar pasaje
    def cobrar_pasaje(self):
        total = self.pasajeros * self.costo
        print(f"El costo total del pasaje es: {total}")

    # (c) Mostrar asientos disponibles
    def mostrar_asientos_disponibles(self):
        print(f"Asientos disponibles: {self.asientos - self.pasajeros}")


if __name__ == "__main__":
    bus = Bus(40)
    bus.subir_pasajeros(17)
    bus.mostrar_asientos_disponibles()
    bus.cobrar_pasaje()
