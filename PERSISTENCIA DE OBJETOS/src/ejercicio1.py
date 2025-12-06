class Charango:
    
    def __init__(self, material="Desconocido", nro_cuerdas=0, cuerdas=None):
        self.material = material
        self.nro_cuerdas = nro_cuerdas
        
        if cuerdas is None:
            self.cuerdas = [False] * 10 
        else:
            self.cuerdas = cuerdas
            
        if nro_cuerdas == 0 and cuerdas is not None:
             self.nro_cuerdas = len(cuerdas)


    def get_material(self):
        return self.material
        
    def get_nro_cuerdas(self):
        return self.nro_cuerdas
        
    def get_cuerdas(self):
        return self.cuerdas

    def get_cuerdas_malas(self):
        malas = 0
        for estado in self.cuerdas:
            if not estado:
                malas += 1
        return malas

    def __str__(self):
        
        if self.cuerdas is not None:
            estado_cuerdas = " ".join(["T" if c else "F" for c in self.cuerdas])
        else:
            estado_cuerdas = "N/A"
            
        return (f"Charango [Material: {self.material}, Nro Cuerdas: {self.nro_cuerdas}, "
                f"Cuerdas (T=Buena, F=Mala): {estado_cuerdas}, "
                f"Cuerdas Malas: {self.get_cuerdas_malas()}]")


if __name__ == "__main__":
    
    cuerdas_c1 = [True, True, False, True, False]
    cuerdas_c2 = [True, True, True, True, True, True, False, False, False, True]
    
    print("--- Charango 1: Caoba de 5 Cuerdas ---")
    c1 = Charango("Caoba", 5, cuerdas_c1)
    print(c1)
    
    print("\n--- Charango 2: Tarco de 10 Cuerdas ---")
    c2 = Charango("Tarco", 10, cuerdas_c2)
    print(c2)
    
    print("\n--- Charango 3: Constructor por Defecto ---")
    c3 = Charango()
    print(c3)
    
    print("\n--- Prueba de Acceso Directo ---")
    print(f"Material del C2: {c2.material}")
    print(f"Número de Cuerdas de C1: {c1.get_nro_cuerdas()}")