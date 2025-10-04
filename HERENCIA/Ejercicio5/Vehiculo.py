class Vehiculo:
    def __init__(self, conductor, placa, id):
        self.conductor = conductor
        self.placa = placa
        self.id = id

    def mostrar_info(self):
        print(f"Placa: {self.placa}, Conductor: {self.conductor}")

    def cambiar_conductor(self, nuevo_conductor):
        self.conductor = nuevo_conductor


class Auto(Vehiculo):
    def __init__(self, conductor, placa, id, caballos_fuerza, descapotable):
        super().__init__(conductor, placa, id)
        self.caballos_fuerza = caballos_fuerza
        self.descapotable = descapotable


class Bus(Vehiculo):
    def __init__(self, conductor, placa, id, capacidad, sindicato):
        super().__init__(conductor, placa, id)
        self.capacidad = capacidad
        self.sindicato = sindicato


class Moto(Vehiculo):
    def __init__(self, conductor, placa, id, cilindrada, casco):
        super().__init__(conductor, placa, id)
        self.cilindrada = cilindrada
        self.casco = casco


if __name__ == "__main__":
    # a) Instanciar un vehículo de cada tipo con valores diferentes
    bus = Bus("María", "BUS-987", 10, 60, "Sindicato B")
    auto = Auto("Jorge", "AUTO-654", 20, 150, False)
    moto = Moto("Elena", "MOTO-321", 30, 500, False)

    # b) Mostrar placa y conductor de cada vehículo
    print("=== Información de Vehículos ===")
    bus.mostrar_info()
    auto.mostrar_info()
    moto.mostrar_info()

    # c) Cambiar el conductor de un vehículo
    print("\n--- Cambiando conductor del Auto ---")
    auto.cambiar_conductor("Raúl")
    auto.mostrar_info()
