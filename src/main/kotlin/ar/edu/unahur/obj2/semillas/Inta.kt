package ar.edu.unahur.obj2.semillas

object Inta {
    var parcelas: MutableList<Parcela> = mutableListOf<Parcela>()

    fun cantidadDePlantasTotal(): Int {
        return parcelas.sumOf { it.cantidadDePlantasEnParcela() }
    }
    fun cantidadDeParcelas(): Int {
        return parcelas.size
    }
    fun promedioDePlantas(): Double {
        if (parcelas.size == 0) {
            return 0.0
        }
        else {
            return (this.cantidadDePlantasTotal() / this.cantidadDeParcelas()).toDouble()
        }
    }
    fun parcelasConMasDexPlantas(x: Int): List<Parcela> {
        return parcelas.filter { it.Plantas.size > x  }
    }
    fun parcelaMasAutosustentable(): Parcela? {
        return this.parcelasConMasDexPlantas(4).maxByOrNull { it.porcentajeDeBienAsociadas() }
    }
}