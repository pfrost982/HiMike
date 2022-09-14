package ru.gb.himike

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import ru.gb.himike.databinding.ActivityMainBinding
import ru.gb.himike.databinding.ItemBottomNavigationBarBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_classes, R.id.navigation_stub1, R.id.navigation_stub2
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

/*
        val bottomNavigationMenuView: BottomNavigationMenuView = binding.navView.getChildAt(0) as BottomNavigationMenuView
        val menu: Menu = binding.navView.menu
        for (i in 0 until menu.size()) {
            val newItemBinding = ItemBottomNavigationBarBinding.inflate(layoutInflater)
            val oldMenuItemView: BottomNavigationItemView = bottomNavigationMenuView.getChildAt(i) as BottomNavigationItemView

            val newMenuItemView: View = newItemBinding.root
            newItemBinding.icon.setImageDrawable(menu.getItem(i).icon)
            newItemBinding.title.text = menu.getItem(i).title

            oldMenuItemView.removeAllViews()
            oldMenuItemView.addView(newMenuItemView)
        }
*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu)
        val searchItem = menu?.findItem(R.id.actionSearch)
        val searchView = searchItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(msg: String): Boolean {
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}