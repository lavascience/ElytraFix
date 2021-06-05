import net.minecraft.entity.item.EntityFireworkRocket
import net.minecraft.network.play.server.SPacketPlayerPosLook
import com.lambda.client.event.events.PacketEvent
import com.lambda.client.module.Category
import com.lambda.client.plugin.api.PluginModule
import com.lambda.client.util.threads.safeListener

internal object ElytraFix: PluginModule(
    name = "ElytraFix",
    category = Category.MISC,
    description = "Remove Firework Rockets on Rubberband",
    pluginMain = ElytraFixPlugin
) {
    init {
        safeListener<PacketEvent.Receive> { event ->
            if (event.packet is SPacketPlayerPosLook && player.isElytraFlying) {
                world.getLoadedEntityList().filterIsInstance<EntityFireworkRocket>().forEach {
                    world.removeEntity(it)
                }
            }
        }
    }
}