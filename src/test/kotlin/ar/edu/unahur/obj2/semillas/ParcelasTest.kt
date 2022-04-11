package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

class ParcelasTest : DescribeSpec ({

    describe("Creacion de parcelas") {
        val soja1 = Soja(2.0, 2021)
        val soja2 = Soja(1.5, 2021)
        val soja3 = Soja(1.2, 2021)
        val soja4 = Soja(3.0, 2021)
        val plantasDeSoja = arrayListOf<Planta>()
        plantasDeSoja.add(soja1)
        plantasDeSoja.add(soja2)
        plantasDeSoja.add(soja3)
        plantasDeSoja.add(soja4)
        // Ver porque no toma el parametro de la coleccion de plantas
        val parcela = Parcela(20.0, 1.0, 10,  plantasDeSoja )

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
})