package debug

import com.example.library.base.BaseApplication
import com.example.library.base.component.Read
import componnent.DaggerMainComponent
import javax.inject.Inject

class MainApplication : BaseApplication() {
    @Inject
    lateinit var read: Read

    override fun onCreate() {
        super.onCreate()
        println("主方法Application")
        DaggerMainComponent.builder().baseComponent(getAppComponent()).build().inject(this)
        read.test()
    }
}
