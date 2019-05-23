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
        assertThat(psyllium.status, instanceOf(LightOnStatus::class.java))
    }

    @Test
    fun testRedToBlue() {
        val psyllium = Psyllium()

        psyllium.lightOn()
        psyllium.lightOn()

        assertThat(psyllium.status, equalTo(Status.BLUE))
    }

    @Test
    fun testBlueToRed() {
        val psyllium = Psyllium()

        psyllium.lightOn()
        psyllium.lightOn()
        psyllium.lightOn()

        assertThat(psyllium.status, equalTo(Status.RED))
    }

    @Test
    fun testRedToNothing() {
        val psyllium = Psyllium()

        psyllium.lightOn()
        psyllium.lightOff()

        assertThat(psyllium.status, equalTo(Status.NOTHING))
    }

    @Test
    fun testBlueToNothing() {
        val psyllium = Psyllium()

        psyllium.lightOn()
        psyllium.lightOn()
        psyllium.lightOff()

        assertThat(psyllium.status, equalTo(Status.NOTHING))
    }

    @Test
    fun testNothingToNothing() {
        val psyllium = Psyllium()

        psyllium.lightOff()

        assertThat(psyllium.status, equalTo(Status.NOTHING))
    }
}