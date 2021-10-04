package nodes

import Entity
import components.CameraComponent
import components.TransformComponent
import nodes.core.BaseNode

data class CameraNode(
    override val entityId: String,
    val cameraComponent: CameraComponent,
    val transformComponent: TransformComponent
) : BaseNode() {

    companion object {
        fun fromEntity(entity: Entity): CameraNode? {
            val cc = entity.getComponent(CameraComponent::class.java.name) as CameraComponent?
            val tc = entity.getComponent(TransformComponent::class.java.name) as TransformComponent?

            return if (cc != null && tc != null) {
                CameraNode(entity.id, cc, tc)
            } else {
                null
            }
        }
    }

}