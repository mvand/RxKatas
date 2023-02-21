import fr.mvand.katas.rx.Location
import fr.mvand.katas.rx.Measures
import fr.mvand.katas.rx.parsing.getTrackSimulation
import org.junit.jupiter.api.Test

class SimpleTest {

    private lateinit var locationList: List<Location>

    private fun getLocationList(): List<Location> = getTrackSimulation("tracks/btwin_to_jdp.gpx")
        .map { Location(it.latitude, it.longitude) }

    @Test
    fun observeLocations() {
        // given
        locationList = getLocationList()

        // when
        val measures = Measures()

        // then
        val test = measures.locations.test()

        test.assertComplete()
        test.assertValueCount(locationList.size)

    }
}