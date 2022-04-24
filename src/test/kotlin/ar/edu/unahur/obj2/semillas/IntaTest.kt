package ar.edu.unahur.obj2.semillas
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class IntaTest : DescribeSpec({
    describe("Promedio de plantas") {
        val soja1 = Soja(2.0, 2021)
        val soja2 = Soja(1.5, 2021)
        val soja3 = Soja(1.2, 2021)
        val soja4 = Soja(3.0, 2021)
        val soja5 = Soja(1.1, 2021)
        val p1 = ParcelaEcologica(20.0, 1.0, 9)
        val menta1 = Menta(2.0, 2021)
        val menta2 = Menta(1.5, 2021)
        val menta3 = Menta(1.2, 2021)
        val menta4 = Menta(3.0, 2021)
        val menta5 = Menta(1.1, 2021)
        val p2 = ParcelaEcologica(20.0, 1.0, 8)
        val quinoa1 = Quinoa(2.0, 2021, 2.0)
        val quinoa2 = Quinoa(1.5, 2021, 3.0)
        val quinoa3 = Quinoa(1.2, 2021, 1.0)
        val quinoa4 = Quinoa(3.0, 2021, 4.0)
        val quinoa5 = Quinoa(1.1, 2021, 5.0)
        val p3 = ParcelaIndustrial(20.0, 1.0, 8)
        it ("Promedio de plantas es cero") {
            Inta.promedioDePlantas().shouldBe(0.0)
        }
        it ("Promedio de plantas es tres") {
           p3.agregarPlanta(soja1)
           p3.agregarPlanta(menta1)
           p3.agregarPlanta(quinoa1)
           p2.agregarPlanta(soja2)
           p2.agregarPlanta(menta2)
           p2.agregarPlanta(quinoa2)
           p1.agregarPlanta(soja3)
           p1.agregarPlanta(menta3)
           p1.agregarPlanta(quinoa3)
           Inta.parcelas.add(p3)
           Inta.parcelas.add(p2)
           Inta.parcelas.add(p1)
           Inta.promedioDePlantas().shouldBe(3.0)
        }
    }
    describe("Parcela mas autosustentable") {
        val soja1 = Soja(2.0, 2021)
        val soja2 = Soja(1.5, 2021)
        val soja3 = Soja(1.2, 2021)
        val soja4 = Soja(3.0, 2021)
        val soja5 = Soja(1.1, 2021)
        val p1 = ParcelaEcologica(20.0, 20.0, 9)
        val menta1 = Menta(2.0, 2021)
        val menta2 = Menta(1.5, 2021)
        val menta3 = Menta(1.2, 2021)
        val menta4 = Menta(3.0, 2021)
        val menta5 = Menta(1.1, 2021)
        val p2 = ParcelaEcologica(20.0, 20.0, 7)
        val quinoa1 = Quinoa(2.0, 2021, 2.0)
        val quinoa2 = Quinoa(1.5, 2021, 3.0)
        val quinoa3 = Quinoa(1.2, 2021, 1.0)
        val quinoa4 = Quinoa(3.0, 2021, 4.0)
        val quinoa5 = Quinoa(1.1, 2021, 5.0)
        val p3 = ParcelaIndustrial(20.0, 20.0, 8)
        it ("No hay parcela autosustentable") {
            Inta.parcelaMasAutosustentable().shouldBeNull()
        }
        it ("Parcela mas autosustentable deberia ser p3") {
            p3.agregarPlanta(soja1)
            p3.agregarPlanta(soja4)
            p3.agregarPlanta(soja5)
            p3.agregarPlanta(menta1)
            p3.agregarPlanta(quinoa1)
            p2.agregarPlanta(soja2)
            p2.agregarPlanta(menta2)
            p2.agregarPlanta(menta4)
            p2.agregarPlanta(menta5)
            p2.agregarPlanta(quinoa2)
            p1.agregarPlanta(soja3)
            p1.agregarPlanta(menta3)
            p1.agregarPlanta(quinoa3)
            p1.agregarPlanta(quinoa4)
            p1.agregarPlanta(quinoa5)
            Inta.parcelas.add(p3)
            Inta.parcelas.add(p2)
            Inta.parcelas.add(p1)
            Inta.parcelaMasAutosustentable().shouldBe(p3)
        }
    }

})
