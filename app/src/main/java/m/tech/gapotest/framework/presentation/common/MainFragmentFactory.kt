package m.tech.gapotest.framework.presentation.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import m.tech.gapotest.framework.presentation.detail.DetailFragment
import m.tech.gapotest.framework.presentation.splash.SplashFragment
import javax.inject.Inject

class MainFragmentFactory
@Inject
constructor(
    private val glide: RequestManager
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        return when (className) {
            SplashFragment::class.java.name -> {
                SplashFragment(glide)
            }

            DetailFragment::class.java.name -> {
                DetailFragment(glide)
            }

            else -> super.instantiate(classLoader, className)
        }

    }
}