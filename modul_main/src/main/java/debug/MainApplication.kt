package debug

import com.example.library.base.BaseApplication
import com.example.library.base.network.WeatherEntity
import com.example.library.base.network.api.ApiSever
import com.example.library.base.network.utils.RxUtil
import componnent.DaggerMainComponent
import io.reactivex.functions.Consumer
import javax.inject.Inject

class MainApplication : BaseApplication() {
    @Inject
    lateinit var apiServer: ApiSever

    override fun onCreate() {
        super.onCreate()
        println("主方法Application")
        DaggerMainComponent.builder().baseComponent(getAppComponent()).build().inject(this)
        apiServer.getTitles("北京").compose(RxUtil.background()).subscribe(
                Consumer<WeatherEntity> {
                    println("----11111111")
                    println(it.data.toString() + "--")
                },
                Consumer<Throwable> {
                    println(it.localizedMessage)
                    println("----222222222")
                }
        )
    }
}
