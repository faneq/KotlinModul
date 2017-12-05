package componnent

import com.example.library.base.component.BaseComponent
import com.example.library.base.component.Read
import dagger.Component
import debug.MainApplication

/**
 * Created by fanenqian on 2017/12/4.
 */
@Component(dependencies = arrayOf(BaseComponent::class))
interface MainComponent {
    fun getRead(): Read
    fun inject(mainApplication: MainApplication)
}