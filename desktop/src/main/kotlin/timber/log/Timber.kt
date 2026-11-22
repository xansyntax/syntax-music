package timber.log

object Timber {
    fun tag(tag: String): Tree = DefaultTree(tag)
    fun d(message: String, vararg args: Any?) = DefaultTree("Timber").d(message, *args)
    fun i(message: String, vararg args: Any?) = DefaultTree("Timber").i(message, *args)
    fun w(message: String, vararg args: Any?) = DefaultTree("Timber").w(message, *args)
    fun w(t: Throwable?, message: String? = null, vararg args: Any?) = DefaultTree("Timber").w(t, message, *args)
    fun e(message: String, vararg args: Any?) = DefaultTree("Timber").e(message, *args)
    fun e(t: Throwable?, message: String? = null, vararg args: Any?) = DefaultTree("Timber").e(t, message, *args)

    open class Tree(private val tag: String) {
        open fun d(message: String, vararg args: Any?) {}
        open fun i(message: String, vararg args: Any?) = println("[$tag] $message")
        open fun w(message: String, vararg args: Any?) = println("[WARN/$tag] $message")
        open fun w(t: Throwable?, message: String? = null, vararg args: Any?) = println("[WARN/$tag] ${message ?: ""} ${t?.message ?: ""}")
        open fun e(message: String, vararg args: Any?) = System.err.println("[ERR/$tag] $message")
        open fun e(t: Throwable?, message: String? = null, vararg args: Any?) {
            System.err.println("[ERR/$tag] ${message ?: ""} ${t?.message ?: ""}")
        }
    }

    private class DefaultTree(tag: String) : Tree(tag)
}
