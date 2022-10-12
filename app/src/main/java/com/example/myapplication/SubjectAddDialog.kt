//과목 추가 버튼을 클릭시 등장하는 커스텀 다이얼로그 작동법
package com.example.myapplication

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.databinding.SubjectAddDialogBinding

class SubjectAddDialog(context: Context) {

    private lateinit var binding: SubjectAddDialogBinding
    private val dialog = Dialog(context)
    fun initSubjectAddDialogViews() = with(binding)
    {
        //Dialog 크기 설정
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        //뒤로가기 버튼, 빈공간 클릭으로 dialog가 사라지지 않도록
        dialog.setCancelable(false)
        //background를 투명하게 만듬. dialog는 내부적으로 뒤에 흰 사각형 배경이 존재하므로 배경을 투명하게 만들지 않으면
        //corner radius의 적용이 보이지 않는다.
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

        //dialog 창에서 취소버튼 클릭시 화면을 끈다.
        noButton.setOnClickListener {
            dialog.dismiss()
        }
        //dialog 창에서 확인버튼 클릭시 dialog 상의 정보를 리사이클러뷰로 subject_select 화면에 표시해준다.
        yesButton.setOnClickListener {
            val subject_name = R.id.subject_name.toString()
            val subject_list = ArrayList<SubjectRecyclerViewItem>()
            subject_list.add(SubjectRecyclerViewItem(subject_name))
            binding.subjectSelectPageRecyclerView.adapter = SubjectRecyclerViewAdapter(subject_list)
        }
    }
    //프로젝트를 추가할 경우 데이터 텍스트에 목록을 추가
    /*todo*/
    fun writeSubjectData(){

    }

}
