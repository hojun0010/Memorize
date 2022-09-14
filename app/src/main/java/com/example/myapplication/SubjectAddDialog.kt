package com.example.myapplication

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.Button

class SubjectAddDialog(context: Context) {
    private val dialog = Dialog(context)

    fun myDig(){
        dialog.setContentView(R.layout.subject_add_dialog)

        //Dialog 크기 설정
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        val okBtn = dialog.findViewById<Button>(R.id.noButton)
        val cancelBtn = dialog.findViewById<Button>(R.id.yesButton)

        okBtn.setOnClickListener {
            onClickListener.onClicked(editText.text.toString())
            dialog.dismiss()
        }

        cancelBtn.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
    interface ButtonClickListener{
        fun onClicked(text: String)
    }

    private lateinit var onClickListener: ButtonClickListener

    fun setOnClickListener(listener: ButtonClickListener){
        onClickListener = listener
    }

}
