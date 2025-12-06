import json
import os

class Trabajador:
    
    def __init__(self, nombre="", carnet=0, salario=0.0):
        self.nombre = nombre
        self.carnet = carnet
        self.salario = salario

    def get_nombre(self):
        return self.nombre

    def get_carnet(self):
        return self.carnet

    def get_salario(self):
        return self.salario
        
    def set_salario(self, salario):
        self.salario = salario

    def __str__(self):
        return f"Trabajador{{nombre={self.nombre}, carnet={self.carnet}, salario={self.salario}}}"

    def to_dict(self):
        return {"nombre": self.nombre, "carnet": self.carnet, "salario": self.salario}

    @staticmethod
    def from_dict(data):
        return Trabajador(data["nombre"], data["carnet"], data["salario"])

class ArchivoTrabajador:

    def __init__(self):
        self.nombre_arch = "trabajadores.json"
        self.trabajadores = []
        self._cargar_archivo()
    
    def _cargar_archivo(self):
        try:
            if os.path.exists(self.nombre_arch):
                with open(self.nombre_arch, 'r') as file:
                    data = json.load(file)
                    self.trabajadores = [Trabajador.from_dict(d) for d in data]
            else:
                self.trabajadores = []
                print("El archivo no existe o no se pudo leer. Se crea una lista vacía.")
        except json.JSONDecodeError:
            self.trabajadores = []
            print("Error al decodificar JSON. Se crea una lista vacía.")
        except Exception:
            self.trabajadores = []
    
    def _buscar_por_carnet(self, carnet):
        for t in self.trabajadores:
            if t.get_carnet() == carnet:
                return t
        raise Exception(f"No existe el trabajador con carnet: {carnet}")
    
    def _existe_carnet(self, carnet):
        for t in self.trabajadores:
            if t.get_carnet() == carnet:
                return True
        return False
    
    def guardar_archivo(self):
        try:
            data = [t.to_dict() for t in self.trabajadores]
            with open(self.nombre_arch, 'w') as file:
                json.dump(data, file, indent=4)
            print("Archivo guardado correctamente.")
        except Exception as e:
            print(f"Error guardando el archivo: {e}")

    def guardar_trabajador(self, t):
        if t is None:
            raise ValueError("El trabajador no puede ser nulo.")
        if self._existe_carnet(t.get_carnet()):
            raise Exception(f"Error: Ya existe un trabajador con el carnet {t.get_carnet()}")
            
        self.trabajadores.append(t)
        self.guardar_archivo()
        
    def aumenta_salario(self, aumento, carnet):
        t = self._buscar_por_carnet(carnet)
        nuevo_salario = t.get_salario() + aumento
        t.set_salario(nuevo_salario)
        print(f"Salario de {t.get_nombre()} (Carnet: {carnet}) aumentado a: {t.get_salario()}")
        self.guardar_archivo()

    def buscar_mayor_salario(self):
        if not self.trabajadores:
            raise Exception("La lista de trabajadores está vacía.")
            
        mayor_salario = self.trabajadores[0]
        
        for t in self.trabajadores[1:]:
            if t.get_salario() > mayor_salario.get_salario():
                mayor_salario = t
        
        return mayor_salario

    def ordenar_por_salario(self):
        if not self.trabajadores:
            raise Exception("No hay trabajadores para ordenar.")
        
        self.trabajadores.sort(key=lambda t: t.get_salario())
        
        print("\n--- Trabajadores ordenados por salario (Ascendente) ---")
        for t in self.trabajadores:
            print(t)
        print("------------------------------------------------------")
        
    def listar_trabajadores(self):
        if not self.trabajadores:
            print("Lista de trabajadores vacía.")
            return
            
        print("\n--- Lista Actual de Trabajadores ---")
        for t in self.trabajadores:
            print(t)
        print("------------------------------------")

if __name__ == "__main__":
    gestor = ArchivoTrabajador()
    gestor.listar_trabajadores()

    print("\n--- PRUEBA DE AGREGAR TRABAJADORES ---")
    try:
        gestor.guardar_trabajador(Trabajador("Ana Lopez", 101, 3000.0))
        gestor.guardar_trabajador(Trabajador("Luis Perez", 102, 5500.0))
        gestor.guardar_trabajador(Trabajador("Carlos M.", 103, 4000.0))

    except Exception as e:
        print(f"ERROR en guardar_trabajador: {e}")
    
    gestor.listar_trabajadores()

    print("\n--- PRUEBA DE AUMENTAR SALARIO (aumenta_salario) ---")
    try:
        gestor.aumenta_salario(500, 101)
    except Exception as e:
        print(f"ERROR en aumenta_salario: {e}")
    
    gestor.listar_trabajadores()

    print("\n--- PRUEBA DE BUSCAR MAYOR SALARIO (buscar_mayor_salario) ---")
    try:
        mayor = gestor.buscar_mayor_salario()
        print(f"El trabajador con mayor salario es: {mayor}")
    except Exception as e:
        print(f"ERROR en buscar_mayor_salario: {e}")

    print("\n--- PRUEBA DE ORDENAR POR SALARIO (ordenar_por_salario) ---")
    try:
        gestor.ordenar_por_salario()
    except Exception as e:
        print(f"ERROR en ordenar_por_salario: {e}")