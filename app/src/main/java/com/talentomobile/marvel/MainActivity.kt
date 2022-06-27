package com.talentomobile.marvel

import android.os.Bundle
import android.view.View
import androidx.core.view.forEach
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import com.talentomobile.marvel.databinding.ActivityMainBinding
import com.talentomobile.marvel.ui.common.BaseActivity
import com.talentomobile.marvel.ui.common.EventObserver
import com.talentomobile.marvel.ui.common.SharedViewModel
import com.talentomobile.marvel.ui.common.extensions.setupWithNavController
import com.talentomobile.marvel.ui.common.extensions.showSnackbarSimple
import com.talentomobile.marvel.ui.common.extensions.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(), NavController.OnDestinationChangedListener {

    private lateinit var binding: ActivityMainBinding
    private var currentNavController: LiveData<NavController>? = null
    private val sharedViewModel: SharedViewModel by viewModel()

    companion object {
        private val TOOLBAR_BACK_BUTTON_EXCLUDED_FRAGMENTS = listOf(
            R.id.charactersFragment,
            R.id.comicsFragment
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            setupBottomNavigationBar()
        }

        initObservers()
    }

    private fun initObservers(){
        sharedViewModel.loading.observe(this, EventObserver {
            binding.includeLoader.mainLayout.visible(it)
        })
        sharedViewModel.feedbackUser.observe(this, EventObserver {
            binding.root.showSnackbarSimple(it.messageResId, it.error)
        })
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        setupBottomNavigationBar()
    }

    /**
     * Called on first creation and when restoring state.
     */
    private fun setupBottomNavigationBar() {
        val bottomNavigationView = binding.bottomNavigation

        val navGraphIds = listOf(
            R.navigation.characters_nav_graph,
            R.navigation.comics_nav_graph,
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.main_nav_host_fragment,
            intent = intent
        )

        // Whenever the selected controller changes, setup the action bar.
        controller.observe(this) { navController ->
            navController.addOnDestinationChangedListener(this)
        }

        binding.bottomNavigation.menu.forEach {
            val view = bottomNavigationView.findViewById<View>(it.itemId)
            view.setOnLongClickListener {
                true
            }
        }
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        supportActionBar?.setDisplayHomeAsUpEnabled(
            !TOOLBAR_BACK_BUTTON_EXCLUDED_FRAGMENTS.contains(destination.id)
        )
    }
}