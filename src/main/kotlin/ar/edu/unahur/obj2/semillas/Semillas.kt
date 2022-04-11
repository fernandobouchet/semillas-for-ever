package ar.edu.unahur.obj2.semillas

abstract class Planta(var altura: Double, open val anioObtencion: Int) {

    open var horasDeSolQueTolera = 7

    open fun esFuerte(): Boolean {
       return horasDeSolQueTolera > 9
    }

    open fun daNuevasSemillas(): Boolean {
        return this.esFuerte()
    }

    abstract fun espacio(): Double
}

open class Menta(altura: Double, anioObtencion: Int) : Planta(altura, anioObtencion) {

    override fun daNuevasSemillas(): Boolean {
        return super.daNuevasSemillas() || this.altura > 0.4
    }

    override fun espacio(): Double {
        return this.altura + 1
    }
}

open class Soja(altura: Double, anioObtencion: Int) : Planta(altura, anioObtencion) {

    override var horasDeSolQueTolera = when {
        this.altura  < 0.5 -> 6
        this.altura in 0.5..1.0 -> 8
        else -> 12
    }

    override fun daNuevasSemillas(): Boolean {
        return super.daNuevasSemillas() || (this.anioObtencion > 2007 && this.altura in 0.75..0.9)
    }

    override fun espacio(): Double {
        return this.altura / 2
    }

}

open class Quinoa(altura: Double, anioObtencion: Int, var espacio: Double): Planta(altura, anioObtencion) {
    override fun espacio(): Double {
        return espacio
    }

    override fun daNuevasSemillas(): Boolean {
        return super.daNuevasSemillas() || this.anioObtencion in 2001..2008
    }

    override var horasDeSolQueTolera: Int = when {
        this.espacio() < 0.3 -> 10
        else -> super.horasDeSolQueTolera
    }
}

class SojaTransgenica(altura: Double, anioObtencion: Int): Soja(altura, anioObtencion) {
    override fun daNuevasSemillas(): Boolean {
        return false
    }
}
class Peperina(altura: Double, anioObtencion: Int): Menta(altura, anioObtencion) {
    override fun espacio(): Double {
        return super.espacio() * 2
    }
}