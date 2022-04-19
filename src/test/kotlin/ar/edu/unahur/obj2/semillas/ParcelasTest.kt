package ar.edu.unahur.obj2.semillas

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ParcelasTest : DescribeSpec ({

    describe("Creacion de parcelas") {
        val soja1 = Soja(2.0, 2021)
        val soja2 = Soja(1.5, 2021)
        val soja3 = Soja(1.2, 2021)
        val soja4 = Soja(3.0, 2021)
        val soja5 = Soja(1.1, 2021)
        val parcela = Parcela(20.0, 1.0, 10)
        parcela.agregarPlanta(soja1)
        parcela.agregarPlanta(soja2)
        parcela.agregarPlanta(soja3)
        parcela.agregarPlanta(soja4)

        it("Probando atributos de parcela") {
            parcela.ancho.shouldBe(20.0)
            parcela.largo.shouldBe(1.0)
            parcela.horasDeSol.shouldBe(10)
            parcela.Plantas.size.shouldBe(4)
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
            exception.message.shouldBe("No se puede plantar porque no hay lugar en la parcela")}
    }
    describe("Parcelas Ideales") {
        val soja1 = Soja(1.0, 2021)
        val menta1 = Menta(1.0, 2008)
        val quinoa1 = Quinoa(1.5, 2006, 5.0)
        val sojaT1 = SojaTransgenica(2.0, 2020)

        val parcela = Parcela(3.0, 8.0, 8)
        val parcela2 = Parcela(1.0, 2.0, 10)


        it("parcela de más de 6 m2 es ideal para menta") {
            menta1.esParcelaIdeal(parcela).shouldBeTrue()
        }
        it("parcela menor a 6 m2 no es ideal para menta") {
            menta1.esParcelaIdeal(parcela2).shouldBeFalse()
        }
        it("parcela con plantas menores a 1.5 mts es ideal para quinoa") {
            parcela.agregarPlanta(soja1)
            parcela.agregarPlanta(menta1)
            quinoa1.esParcelaIdeal(parcela).shouldBeTrue()
        }
        it("parcela con una planta de altura > 1.5 ya no es ideal para Quinoa") {
            parcela.agregarPlanta(soja1)
            parcela.agregarPlanta(menta1)
            parcela.agregarPlanta(sojaT1)
            quinoa1.esParcelaIdeal(parcela).shouldBeFalse()
        }
        it("parcela con la misma tolerancia al sol es ideal para Soja común") {
            soja1.esParcelaIdeal(parcela).shouldBeTrue()
        }
        it("parcela con distinta tolerancia al sol no es ideal para Soja común") {
            soja1.esParcelaIdeal(parcela2).shouldBeFalse()
        }
        it("parcela con cantidad maxima de plantas > 1 no es ideal de soja transgenica") {
            sojaT1.esParcelaIdeal(parcela).shouldBeFalse()
        }
    }
})