//프로젝트 추가 완료시 스크롤뷰에 리사이클러뷰로 정의된 커스텀 리사이클러뷰 형태로 프로젝트를 전사

package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SubjectRecyclerViewAdapter (val subjectRecyclerViewItemList : ArrayList<SubjectRecyclerViewItem>) :
    RecyclerView.Adapter<SubjectRecyclerViewAdapter.CustomViewHolder>() {

    // 현재 리사이클러뷰의 dataset item의 길이를 반환 (invoked by the layout manager)
    override fun getItemCount() : Int{
        return subjectRecyclerViewItemList.size
    }
    //activity main의 oncreate와 비슷한 역할. 미리 만들어둔 list를 원하는 화면에 붙이는 역할
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SubjectRecyclerViewAdapter.CustomViewHolder {
        // Create a new view, which defines the UI of the list item
        //view는 subject_select 레이아웃이다.
        val view = LayoutInflater.from(viewGroup.context) //context란 activity에서 담고있는 모든 정보
            .inflate(R.layout.subject_list_item, viewGroup, false)
        //inflate는 붙이다는 뜻, 붙일 list xml이름,
        //viewHolder에 리사이클러뷰가 존재하는 레이아웃 객체를 인자로 넘겨준다.
        return CustomViewHolder(view) //onCreateViewHolder에서 val view를 만들어주고 이것을 리턴
    }
    // 뷰의 내용을 대체한다. (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: CustomViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //view의 내용을 붙잡고 있는다. -> 스크롤로 인한 item 대체를 위해 붙잡고 있는 역할
        viewHolder.recycler_subject_name_Id.text = subjectRecyclerViewItemList[position].name
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //view에 대한 타입을 알려줘야한다
        val recycler_subject_name_Id = itemView.findViewById<TextView>(R.id.subject_name) //리사이클러뷰에서의 id값)

    }

}