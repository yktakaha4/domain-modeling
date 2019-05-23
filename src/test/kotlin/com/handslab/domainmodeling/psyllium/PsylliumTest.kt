package com.handslab.domainmodeling.psyllium

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class PsylliumTest {

    @Test
    fun testNothingToRed() {
        val psyllium = Psyllium()

        psyllium.lightOn()

        val status = psyllium.status as LightOnStatus
        assertThat(status.color, equalTo(Color.RED))
    }

    @Test
    fun testRedToBlue() {
        val psyllium = Psyllium()

        psyllium.lightOn()
        psyllium.lightOn()

        val status = psyllium.status as LightOnStatus
        assertThat(status.color, equalTo(Color.BLUE))
    }

    @Test
    fun testBlueToRed() {
        val psyllium = Psyllium()

        psyllium.lightOn()
        psyllium.lightOn()
        psyllium.lightOn()

        val status = psyllium.status as LightOnStatus
        assertThat(status.color, equalTo(Color.RED))
    }

    @Test
    fun testRedToNothing() {
        val psyllium = Psyllium()

        psyllium.lightOn()
        psyllium.lightOff()

        assertThat(psyllium.status, instanceOf(LightOffStatus::class.java))
    }

    @Test
    fun testBlueToNothing() {
        val psyllium = Psyllium()

        psyllium.lightOn()
        psyllium.lightOn()
        psyllium.lightOff()

        assertThat(psyllium.status, instanceOf(LightOffStatus::class.java))
    }

    @Test
    fun testNothingToNothing() {
        val psyllium = Psyllium()

        psyllium.lightOff()

        assertThat(psyllium.status, instanceOf(LightOffStatus::class.java))
    }
}