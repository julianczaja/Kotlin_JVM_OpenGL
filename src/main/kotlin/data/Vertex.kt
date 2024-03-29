package data

import glm_.vec2.Vec2
import glm_.vec3.Vec3
import utils.Debug

data class Vertex(
    val position: Vec3,
    val normal: Vec3?,
    var color: Vec3?,
    val textureCoordinates: Vec2?
) {

//    constructor() : this(Vec3(), Vec3(), Vec3(), Vec2())

//    companion object {
//        fun empty(): Vertex {
//            return Vertex(Vec3(), Vec3(), Vec2())
//        }
//    }

    fun convertToFloatArray(): FloatArray {

        val arr = arrayListOf(position.x, position.y, position.z)

        this.normal?.let {
            arr.add(it.x)
            arr.add(it.y)
            arr.add(it.z)
        }

        this.color?.let {
            arr.add(it.x)
            arr.add(it.y)
            arr.add(it.z)
        }

        this.textureCoordinates?.let {
            arr.add(it.x)
            arr.add(it.y)
        }

        return arr.toFloatArray()

//        return if (normal == null) {
//            floatArrayOf(
//                position.x, position.y, position.z,
//                textureCoordinates.x, textureCoordinates.y
//            )
//        } else {
//            floatArrayOf(
//                position.x, position.y, position.z,
//                normal.x, normal.y, normal.z,
//                textureCoordinates.x, textureCoordinates.y
//            )
//        }
    }
}