import com.lambda.client.plugin.api.Plugin

internal object ElytraFixPlugin: Plugin() {

    override fun onLoad() {
        // Load any modules, commands, or HUD elements here
        modules.add(ElytraFix)
    }

    override fun onUnload() {
        // Here you can unregister threads etc...
    }
}