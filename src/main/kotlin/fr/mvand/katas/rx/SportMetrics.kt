package fr.mvand.katas.rx

import io.reactivex.rxjava3.core.Observable
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

data class Location(
    val latitude: Double,
    val longitude: Double,
    val accuracy: Float = 1.0f
) {

    /** Returns distance (in meters) between this and the other location using haversine formula. (φ: lat | λ: lon)
     ** @see [https://en.wikipedia.org/wiki/Haversine_formula]
     **/
    fun distanceTo(other: Location): Double {
        val R = 6371e3 // metres
        val φ1 = this.latitude * Math.PI / 180 // φ, λ in radians
        val φ2 = other.latitude * Math.PI / 180
        val Δφ = (other.latitude - this.latitude) * Math.PI / 180
        val Δλ = (other.longitude - this.longitude) * Math.PI / 180

        val a = sin(Δφ / 2) * sin(Δφ / 2) +
                cos(φ1) * cos(φ2) *
                sin(Δλ / 2) * sin(Δλ / 2);
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))

        val d = R * c // in metres
        return d
    }
}

data class Measures(
    val locations: Observable<Location> = Observable.empty(),
    val distances: Observable<Long> = Observable.empty(), // in m
    val speed: Observable<Float> = Observable.empty(), // in m/s
    val pace: Observable<Float> = Observable.empty(), // in min/km
)