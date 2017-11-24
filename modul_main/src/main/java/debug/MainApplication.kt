package debug

import com.example.library.base.BaseApplication

class MainApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        println("主方法Application")
    }
}
