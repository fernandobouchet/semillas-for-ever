package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ParcelasTest : DescribeSpec ({

    describe("Creacion de parcelas") {
        val soja1 = Soja(2.0, 2021)
        val soja2 = Soja(1.5, 2021)
        val soja3 = Soja(1.2, 2021)
        val soja4 = Soja(3.0, 2021)
        // Ver porque no toma el parametro de la coleccion de plantas
        val parcela = Parcela(20.0, 1.0, 10,   )

        it("Probando atributos de parcela") {
            parcela.ancho.shouldBe(20.0)
            parcela.largo.shouldBe(1.0)
            parcela.horasDeSol.shouldBe(10)
            //parcela.plantas.shouldContain(plantasDeSoja)
        }

        it("Testeando superficie y cantidad maxima de plantas") {
            parcela.superficie().shouldBe(20)
            parcela.cantidadMaximaDePlantas().shouldBe(4)
        }
    }
    describe("Parcelas Ideales") {
        val soja1 = Soja(2.0, 2021)
        val menta1 = Menta(3.0, 2008)
        val peperina1 = Peperina(2.0, 2007)
        val quinoa1 = Quinoa(1.5, 2006, 5.0)
        val sojaT1 = SojaTransgenica(2.0, 2020)

        val plantas1 = mutableSetOf<Planta>(soja1, menta1, peperina1, quinoa1, sojaT1)

        val parcela = Parcela(3.0, 8.0, 12, plantas1)

        it("parcela ideal de menta") {
            menta1.esParcelaIdeal(parcela).shouldBeTrue()
        }
        it("parcela ideal de quinoa") {
            quinoa1.esParcelaIdeal(parcela).shouldBeTrue()
        }
        it("parcela ideal de soja") {
            soja1.esParcelaIdeal(parcela).shouldBeTrue()
        }
        it("parcela ideal de soja transgenica") {
            sojaT1.esParcelaIdeal(parcela).shouldBeTrue()
        }
    }
})