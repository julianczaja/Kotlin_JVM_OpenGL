package nodes

import Entity
import components.ModelComponent
import components.PositionComponent
import nodes.core.BaseNode

data class RenderNode(
    override val entityId: String,
    val positionComponent: PositionComponent,
    val modelComponent: ModelComponent
) : BaseNode() {

    companion object {
        fun fromEntity(entity: Entity): RenderNode? {
            val pc = entity.getComponent(PositionComponent::class.java.name) as PositionComponent?
            val mc = entity.getComponent(ModelComponent::class.java.name) as ModelComponent?

            return if (pc != null && mc != null) {
                RenderNode(entity.id, pc, mc)
            } else {
                null
            }
        }
    }

}
