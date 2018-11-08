package nl.vollo.kern

import nl.vollo.kern.testdata.TestdataGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class VolloBoot {

    @Autowired
    private lateinit var testdataGenerator: TestdataGenerator

    @PostMapping("/public/testdata")
    fun genererenTestdata() {
        testdataGenerator.genereren()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<VolloBoot>(*args)
        }
    }
}