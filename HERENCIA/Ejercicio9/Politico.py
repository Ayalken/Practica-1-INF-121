class Politico:
    def __init__(self, profesion, añosExp):
        self.profesion = profesion
        self.añosExp = añosExp

    def get_profesion(self):
        return self.profesion

    def get_añosExp(self):
        return self.añosExp

class Partido:
    def __init__(self, nombreP, rol):
        self.nombreP = nombreP
        self.rol = rol

    def get_nombreP(self):
        return self.nombreP

    def get_rol(self):
        return self.rol

class Presidente(Politico):
    def __init__(self, nombre, apellido, profesion, añosExp, nombreP, rol):
        super().__init__(profesion, añosExp)
        self.nombre = nombre
        self.apellido = apellido
        self.partido = Partido(nombreP, rol)

    def get_nombre(self):
        return self.nombre

    def get_apellido(self):
        return self.apellido

    def get_partido(self):
        return self.partido


if __name__ == "__main__":
    # b) Instanciar de dos formas diferentes un presidente
    p1 = Presidente("Andres", "Quispe", "Ingeniero Civil", 18, "Partido Verde", "Líder")
    p2 = Presidente("Lucia", "Mamani", "Doctora", 12, "Partido Social", "Vocera")

    # c) Crear lista de presidentes con mínimo 3
    presidentes = [p1, p2, Presidente("Roberto", "Flores", "Profesor", 25, "Partido Obrero", "Secretario")]

    nombre_buscado = "Lucia"
    for p in presidentes:
        if p.get_nombre().lower() == nombre_buscado.lower():
            print("Presidente encontrado:", p.get_nombre(), p.get_apellido())
            print("Partido:", p.get_partido().get_nombreP())
            print("Profesión:", p.get_profesion())
