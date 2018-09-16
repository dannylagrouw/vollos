package nl.vollo.kern.model;

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Adres(
        @Column
        val straat: String?,

        @Column(length = 10)
        val huisnummer: String?,

        @Column(length = 10)
        val toevoeging: String?,

        @Column(length = 10)
        val postcode: String?,

        @Column
        val plaats: String?,

        @Column
        val land: String? = "Nederland"
) : Serializable