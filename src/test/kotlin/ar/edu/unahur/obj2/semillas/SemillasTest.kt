package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class SemillasTest : DescribeSpec ({
    // hay una clase Planta que tiene por atributos
    // anioSemilla, altura
    describe("Creación de las plantas") {
        val menta = Menta(1.0, 2021)
        val mentita = Menta(0.3, 2021)
        val soja = Soja(0.6, 2009)
        val quinoa = Quinoa(0.1, 2010, 0.2)
        val quinoa2 = Quinoa(0.5, 2006, 0.9)
        val sojaTransgenica = SojaTransgenica(0.5, 2020)
        val peperina = Peperina(2.1, 2018)

        it("probamos los atributos altura  y anioSemilla") {
            menta.altura.shouldBe(1.0)
            menta.anioObtencion.shouldBe(2021)
        }

        it("verificar si da semillas") {
            menta.daNuevasSemillas().shouldBeTrue()
            mentita.daNuevasSemillas().shouldBeFalse()
            quinoa.daNuevasSemillas().shouldBeTrue()
            quinoa2.daNuevasSemillas().shouldBeTrue()
            soja.daNuevasSemillas().shouldBeFalse()
            sojaTransgenica.daNuevasSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            menta.esFuerte().shouldBeFalse()
            soja.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            menta.espacio().shouldBe(2.0)
            mentita.espacio().shouldBe(1.3)
            soja.espacio().shouldBe(0.3)
            peperina.espacio().shouldBe(6.2)
            quinoa.espacio().shouldBe(0.2)
            quinoa2.espacio().shouldBe(0.9)
        }

        it("horas de sol que tolera") {
            soja.horasDeSolQueTolera.shouldBe(8)
            quinoa.horasDeSolQueTolera.shouldBe(10)
            quinoa2.horasDeSolQueTolera.shouldBe(7)
        }
        it("verifico la suma de varias") {
            val superficie = mutableListOf(
                soja.espacio(),
                menta.espacio(),
                mentita.espacio()
            ).sum()
            Math.ceil(superficie).shouldBe(4)
        }
    }
})