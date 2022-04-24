package ar.edu.unahur.obj2.semillas

open class Parcela(var ancho: Double, var largo: Double, var horasDeSol: Int) {

    val Plantas: MutableSet<Planta> = mutableSetOf<Planta>()

    fun superficie(): Double {
        return this.ancho * this.largo
    }

    fun cantidadMaximaDePlantas(): Double {
        return when {
            this.ancho > this.largo -> this.superficie() / 5
            else -> this.superficie() / 3 + this.largo
        }
    }
    fun tieneComplicaciones(): Boolean {
        return Plantas.any {it.horasDeSolQueTolera < this.horasDeSol}
    }
    fun agregarPlanta(Planta: Planta) {
        if (this.horasDeSol > Planta.horasDeSolQueTolera + 2) {
            throw Exception("No se puede plantar porque las horas de sol de la parcela son dos mas de las que tolera la planta")
        }
        else if (this.cantidadMaximaDePlantas() == Plantas.size.toDouble()) {
            throw Exception("No se puede plantar porque no hay lugar en la parcela")
        }
        else Plantas.add(Planta)
    }
    fun cantidadDePlantasEnParcela(): Int {
        return Plantas.size
    }
    open fun seAsociaBien(planta: Planta): Boolean{
        throw Exception("No se puede calcular porque es una parcela normal")
    }
    fun porcentajeDeBienAsociadas() : Double {
        return (Plantas.filter { this.seAsociaBien(it) }.size * Plantas.size / 100).toDouble()
    }
}

class ParcelaEcologica(ancho: Double, largo: Double, horasDeSol: Int) : Parcela(ancho, largo, horasDeSol) {
    override fun seAsociaBien(planta: Planta): Boolean {
        return !this.tieneComplicaciones() && planta.esParcelaIdeal(this)
    }
}

class ParcelaIndustrial(ancho: Double,largo: Double,horasDeSol: Int) : Parcela(ancho, largo, horasDeSol) {
    override fun seAsociaBien(planta: Planta): Boolean {
        return this.Plantas.size <= 2 && planta.esFuerte()
    }
}