package legom.handbagshop.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import legom.handbagshop.R
import legom.handbagshop.databinding.ActivityMainBinding
import legom.handbagshop.presentation.fragments.BasketFragment
import legom.handbagshop.presentation.fragments.FavoritesFragment
import legom.handbagshop.presentation.fragments.MainFragment
import legom.handbagshop.presentation.fragments.ProfileFragment
import legom.handbagshop.presentation.fragments.openFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onBottomNavClicks()
        openFragment(MainFragment.newInstance())
    }

    private fun onBottomNavClicks(){
        binding.bNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    openFragment(MainFragment.newInstance())
                }
                R.id.basket -> {
                    openFragment(BasketFragment.newInstance())
                }
                R.id.favorite -> {
                    openFragment(FavoritesFragment.newInstance())
                }
                R.id.profile -> {
                    openFragment(ProfileFragment.newInstance())
                }

            }
            true
        }
    }
}