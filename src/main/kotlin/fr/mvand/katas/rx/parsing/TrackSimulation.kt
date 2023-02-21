package fr.mvand.katas.rx.parsing

import fr.mvand.katas.rx.parsing.dto.GpxDTO
import fr.mvand.katas.rx.parsing.dto.TrackPointDTO
import org.simpleframework.xml.core.Persister
import java.io.File

fun getTrackSimulation(pathToFile: String): List<TrackPointDTO> {
    val resourcePath = "src/main/resources/$pathToFile"
    val gpxFile = File(resourcePath)
    val serializer = Persister()
    return serializer.read(GpxDTO::class.java, gpxFile).track?.points ?: emptyList()
}