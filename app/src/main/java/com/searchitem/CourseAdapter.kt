package com.searchitem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CourseAdapter(
    private var courseModelArrayList: ArrayList<CourseModel>
) :
    RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    fun filterList(filterList: ArrayList<CourseModel>) {
        courseModelArrayList = filterList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_search, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = courseModelArrayList[position]
        holder.courseNameTV.text = model.courseName
        holder.courseDescTV.text = model.courseDescription
    }

    override fun getItemCount(): Int {
        return courseModelArrayList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseNameTV: TextView
        val courseDescTV: TextView

        init {
            courseNameTV = itemView.findViewById(R.id.idTVCourseName)
            courseDescTV = itemView.findViewById(R.id.idTVCourseDescription)
        }
    }
}