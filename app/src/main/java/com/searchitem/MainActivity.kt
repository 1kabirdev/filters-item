package com.searchitem

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var courseRV: RecyclerView
    private var adapter: CourseAdapter? = null
    private var courseList: ArrayList<CourseModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        courseRV = findViewById(R.id.idRVCourses)
        buildRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search_menu, menu)
        val searchItem: MenuItem = menu.findItem(R.id.actionSearch)
        val searchView: SearchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText.toString())
                return false
            }
        })
        return true
    }


    private fun filter(text: String) {
        val filterList = ArrayList<CourseModel>()
        for (item in courseList) {
            if (item.courseName.lowercase(Locale.getDefault())
                    .contains(text.lowercase(Locale.getDefault()))
            ) filterList.add(item)
        }
        if (filterList.isNotEmpty())
            adapter!!.filterList(filterList)
        else Toast.makeText(
            this,
            "$text No Data Found..",
            Toast.LENGTH_SHORT
        ).show()
    }


    private fun buildRecyclerView() {
        courseList.add(CourseModel("DSA", "DSA Self Paced Course"))
        courseList.add(CourseModel("JAVA", "JAVA Self Paced Course"))
        courseList.add(CourseModel("C++", "C++ Self Paced Course"))
        courseList.add(CourseModel("Python", "Python Self Paced Course"))
        courseList.add(CourseModel("Fork CPP", "Fork CPP Self Paced Course"))
        courseList.add(CourseModel("KOTLIN", "KOTLIN Self Paced Course"))
        courseList.add(CourseModel("C#", "C# Self Paced Course"))
        courseList.add(CourseModel("C", "C Self Paced Course"))
        courseList.add(CourseModel("JavaScript", "JavaScript Self Paced Course"))

        adapter = CourseAdapter(courseList)
        val manager = LinearLayoutManager(this)
        courseRV.setHasFixedSize(true)
        courseRV.layoutManager = manager
        courseRV.adapter = adapter
    }
}