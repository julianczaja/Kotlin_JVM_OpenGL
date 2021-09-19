//package collision
//
//import Texture
//import data.Mesh
//import data.Vertex
//import glm_.mat4x4.Mat4
//import glm_.vec2.Vec2
//import glm_.vec4.Vec4
//import models.base.Model
//import models.base.ModelNoLight
//import org.lwjgl.opengl.GL33.*
//import utils.Debug
//
//class AxisAlignedBoundingBox(modelMesh: Mesh) : Model(modelM) {
//    companion object {
//        val TAG: String = this::class.java.name
//        val uvs = Vec2(0f, 0f) // Yellow
//
//        const val VERTEX_SIZE = 5
//    }
//
//    var boundingPoints = BoundingPoints()
//    private var primaryMesh: Mesh
//    override var mesh: Mesh? = null
//
//    init {
//        addTexture(Texture.getDefaultColorPalette())
//        boundingPoints = BoundingBoxUtils.calculateBoundingPoints(modelMesh.vertices)
//        primaryMesh = BoundingBoxUtils.createMesh(boundingPoints, uvs)
//        addMesh(primaryMesh)
//        create()
//    }
//
//    fun update(transformationMat: Mat4) {
//        // Calculate oriented bounding box
//        val transformedVertices = ArrayList<Vertex>()
//        primaryMesh.vertices.forEach { vertex ->
//            val transformedPosition = transformationMat.times(Vec4(vertex.position, 1f)).toVec3()
//            transformedVertices.add(Vertex(transformedPosition, null, null, uvs))
//        }
//
//        // Calculate axis aligned bounding box over oriented one
//        boundingPoints = BoundingBoxUtils.calculateBoundingPoints(transformedVertices)
//        mesh = BoundingBoxUtils.createMesh(boundingPoints, uvs)
//        uploadVertices(mesh!!, vertexSize = 5)
//    }
//
//    fun draw() {
//        ModelNoLight.shaderProgram.setUniformMat4f("m", transformationMat)
//        bind()
//        texture.bind()
//        glDrawElements(GL_LINES, getIndicesCount(), GL_UNSIGNED_INT, 0)
//    }
//
//    override fun addMesh(mesh: Mesh) {
//        this.mesh = mesh
//    }
//
//    override fun create() {
//        if (mesh != null) {
//            this.vao = glGenVertexArrays()
//            this.vbo = glGenBuffers()
//            this.ebo = glGenBuffers()
//
//            uploadVertices(mesh!!, vertexSize = 5)
//            uploadIndices(mesh!!)
//
//            // 3 Float vertex coordinates
//            glVertexAttribPointer(0, 3, GL_FLOAT, false, VERTEX_SIZE * Float.SIZE_BYTES, 0)
//            glEnableVertexAttribArray(0)
//            // 2 Float vertex texture coordinates
//            glVertexAttribPointer(1, 2, GL_FLOAT, false, VERTEX_SIZE * Float.SIZE_BYTES, 3L * Float.SIZE_BYTES)
//            glEnableVertexAttribArray(1)
//
//            // Unbind VBO and VAO
//            glBindBuffer(GL_ARRAY_BUFFER, 0)
//            glBindVertexArray(0)
//
//            Debug.logd(TAG, "AxisAlignedBoundingBox created!")
//        } else {
//            throw RuntimeException("Can't create Model without added Mesh!")
//        }
//    }
//}