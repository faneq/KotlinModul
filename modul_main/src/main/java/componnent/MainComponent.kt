package componnent

import com.example.library.base.PerActivity
import com.example.library.base.component.BaseComponent
import dagger.Component
import debug.MainApplication

/**
 * Created by fanenqian on 2017/12/4.
 */
@PerActivity
@Component(dependencies = arrayOf(BaseComponent::class))
interface MainComponent {
    fun inject(mainApplication: MainApplication)
}

