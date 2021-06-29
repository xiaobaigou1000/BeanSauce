package ink.xiaobaigou.beansauce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ink.xiaobaigou.beansauce.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = navHostFragment.navController
            bottomNavigation.setupWithNavController(navController)
            topAppBar.setupWithNavController(navController)

            navController.addOnDestinationChangedListener { controller, destination, arguments ->
                if(destination.id==R.id.newsDetailFragment){
                    bottomNavigation.visibility= View.GONE
                    topAppBar.visibility=View.GONE
                }else{
                    bottomNavigation.visibility=View.VISIBLE
                    topAppBar.visibility=View.VISIBLE
                }
            }
        }
    }
}