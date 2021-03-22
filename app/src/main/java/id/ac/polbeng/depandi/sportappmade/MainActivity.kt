package id.ac.polbeng.depandi.sportappmade

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import id.ac.polbeng.depandi.sportappmade.databinding.ActivityMainBinding
import id.ac.polbeng.depandi.sportappmade.ui.favorite_player.FavoritePlayerFragment
import id.ac.polbeng.depandi.sportappmade.ui.player.PlayerFragment
import id.ac.polbeng.depandi.sportappmade.ui.sport.SportFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, SportFragment())
                .commit()
            supportActionBar?.title = getString(R.string.menu_sport)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        var title = getString(R.string.menu_sport)
        when (item.itemId) {
            R.id.nav_sport-> {
                fragment = SportFragment()
                title = getString(R.string.menu_sport)
            }
            R.id.nav_player -> {
                fragment = PlayerFragment()
                title = getString(R.string.menu_player)
            }
            R.id.nav_favorite_player -> {
                fragment = FavoritePlayerFragment()
                title = getString(R.string.menu_favorite_player)
            }
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
        }
        supportActionBar?.title = title

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}