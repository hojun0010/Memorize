package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SubjectRecyclerViewAdapter (val subjectList : ArrayList<Subject>) :
    RecyclerView.Adapter<SubjectRecyclerViewAdapter.CustomViewHolder>() {

    //activity main의 oncreate와 비슷한 역할. 미리 만들어둔 list를 원하는 화면에 붙이는 역할
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SubjectRecyclerViewAdapter.CustomViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context) //context란 activity에서 담고있는 모든 정보
            .inflate(R.layout.subject_list_item, viewGroup, false)
        //inflate는 붙이다는 뜻, 붙일 list xml이름,
        return CustomViewHolder(view) //onCreateViewHolder에서 val view를 만들어주고 이것을 리턴
    }
    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: CustomViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.sj_name.text = subjectList.get(position).name
    }
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = 0

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //view에 대한 타입을 알려줘야한다
        val sj_name = itemView.findViewById<TextView>(R.id.subject_name) //리사이클러뷰에서의 id값)

    }

}