package systems

import nodes.MoveNode
import systems.core.BaseSystem
import utils.Debug

object MoveSystem : BaseSystem() {
    val TAG: String = this::class.java.name

    var moveNodes = mutableListOf<MoveNode>()

    override fun update(deltaTime: Float) {
        if (!isStarted) return
        Debug.logd(TAG, "update (deltaTime=$deltaTime)")

        for (moveNode in moveNodes) {
            moveNode.positionComponent.position.plusAssign(moveNode.velocityComponent.velocity)
        }
    }
}