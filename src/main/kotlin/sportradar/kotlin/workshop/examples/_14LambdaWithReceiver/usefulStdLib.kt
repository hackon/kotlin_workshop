package sportradar.kotlin.workshop.examples._14LambdaWithReceiver

fun main(args: Array<String>) {
  // WITH
  val window = Window()
  with(window) {
    width = 300
    height = 200
    isVisible = true
  }

  val windowById: Map<String, Window?> = mapOf("main" to window)
  val windowOrNull: Window? = windowById["main"]

  // RUN, with but extension
  windowOrNull?.run {
    width = 300
    height = 200
    isVisible = true
  }

  windowById["main"]?.run {
    width = 300
    height = 200
    isVisible = true
  }

  // APPLY returns receiver as result
  windowById["main"]?.apply {
    width =300
    height=200
    isVisible=true
  } ?: return


  // ALSO regular argument instead of this
  windowById["main"]?.apply {
    width =300
    height=200
    isVisible=true
  } ?.also {
    showWindow(it)
  }


}

fun showWindow(it: Window) {
  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

data class Window(var width: Int = 0, var height: Int = 0, var isVisible: Boolean = false)