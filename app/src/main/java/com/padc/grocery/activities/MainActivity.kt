package com.padc.grocery.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.grocery.R
import com.padc.grocery.adapters.GroceryAdapter
import com.padc.grocery.dialogs.GroceryDialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mAdapter: GroceryAdapter = GroceryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        setUpRecyclerView()

        setUpActionListeners()
    }

    private fun setUpActionListeners() {
        fab.setOnClickListener {
            GroceryDialogFragment.newFragment().show(supportFragmentManager, GroceryDialogFragment.TAG_ADD_GROCERY_DIALOG)
        }
    }

    private fun setUpRecyclerView() {
        rvGroceries.adapter = mAdapter
        rvGroceries.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}