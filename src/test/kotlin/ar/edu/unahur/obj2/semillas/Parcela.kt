package ar.edu.unahur.obj2.semillas

class Parcela(var ancho: Double, var largo: Double, var horasDeSol: Int, val plantas: MutableList<Planta> = arrayListOf<Planta>()) {

    fun superficie(): Double {
        return this.ancho * this.largo
    }

    fun cantidadMaximaDePlantas(): Double {
        return when {
            this.ancho > this.largo -> this.superficie() / 5
            else -> this.superficie() / 3 + this.largo
        }
    }
}
