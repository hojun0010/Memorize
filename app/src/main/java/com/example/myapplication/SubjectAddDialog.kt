//과목 추가 버튼을 클릭시 등장하는 커스텀 다이얼로그 작동법
package com.example.myapplication

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText

class SubjectAddDialog(context: Context) {
    private val dialog = Dialog(context)

    fun MysubjectadddDdalog(){
        dialog.setContentView(R.layout.subject_add_dialog)

        //Dialog 크기 설정
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        val ProjectAddDialogCancelBtn = dialog.findViewById<Button>(R.id.noButton)
        val ProjectAddDialogYesBtn = dialog.findViewById<Button>(R.id.yesButton)


        ProjectAddDialogCancelBtn.setOnClickListener {
            dialog.dismiss()
        }

        ProjectAddDialogYesBtn.setOnClickListener {
            val subject_name = dialog.findViewById<EditText>(R.id.subject_name)
            val subject_spect = dialog.findViewById<EditText>(R.id.subject_spec)

            SubjectDialogAddListener.onClicked(subject_name)
            dialog.dismiss()
        }
        dialog.show()
    }
    interface SubjectDialogAddListener{
        fun onClicked(text: String)
    }

    private lateinit var onClickListener: ButtonClickListener

    fun setOnClickListener(listener: ButtonClickListener){
        onClickListener = listener
    }

}
