package ar.edu.unahur.obj2.semillas

import io.kotest.assertions.show.show
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.startWith
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith

class ParcelasTest : DescribeSpec ({

    describe("Creacion de parcelas") {
        val soja1 = Soja(2.0, 2021)
        val soja2 = Soja(1.5, 2021)
        val soja3 = Soja(1.2, 2021)
        val soja4 = Soja(3.0, 2021)
        val soja5 = Soja(0.1, 2021)
        val plantasDeSoja = mutableListOf<Planta>(soja1, soja2,soja3, soja4)
        val parcela = Parcela(20.0, 1.0, 10, plantasDeSoja)

        it("Probando atributos de parcela") {
            parcela.ancho.shouldBe(20.0)
            parcela.largo.shouldBe(1.0)
            parcela.horasDeSol.shouldBe(10)
            parcela.plantas.size.shouldBe(4)
        }

        it("Testeando superficie y cantidad maxima de plantas") {
            parcela.superficie().shouldBe(20)
            parcela.cantidadMaximaDePlantas().shouldBe(4)
        }

        it("Testeando si la parcela tiene complicaciones") {
            parcela.tieneComplicaciones().shouldBe(false)
        }

        it("Intentamos agregar una quinta planta") {
            val exception = shouldThrow<Exception> {parcela.agregarPlanta(soja5)}
            exception.message.shouldBe("No se puede plantar porque no hay lugar en la parcela")
        }
    }
})