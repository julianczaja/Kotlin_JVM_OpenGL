import light.Light
import models.ModelDefault
import models.ModelNoLight

class World {

    var modelsDefault: ArrayList<ModelDefault> = ArrayList()
    var modelsNoLight: ArrayList<ModelNoLight> = ArrayList()
    val lightSources: ArrayList<Light> = ArrayList()
    val terrains: ArrayList<Terrain> = ArrayList()

    var skybox: Skybox? = null


    fun addModelDefault(model: ModelDefault) {
        modelsDefault.add(model)
    }

    fun addModelNoLight(modelNoLight: ModelNoLight) {
        modelsNoLight.add(modelNoLight)
    }

    fun addLightSource(lightSource: Light) {
        lightSources.add(lightSource)
    }

    fun addTerrain(terrain: Terrain) {
        terrains.add(terrain)
    }

    fun cleanup() {
        // TODO: implement
    }
}
