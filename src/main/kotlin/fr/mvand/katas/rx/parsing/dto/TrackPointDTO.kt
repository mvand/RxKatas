package fr.mvand.katas.rx.parsing.dto

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(strict = false)
data class GpxDTO(
    @field:Element(name = "trk", required = true) var track: TrackDTO? = null
)

@Root(strict = false)
data class TrackDTO(
    @field:ElementList(name = "trkseg", entry = "trkpt") var points: MutableList<TrackPointDTO> = mutableListOf()
)

@Root(name = "trkpt", strict = false)
data class TrackPointDTO(
    @field:Attribute(name = "lat") var latitude: Double = 0.0,
    @field:Attribute(name = "lon") var longitude: Double = 0.0
)