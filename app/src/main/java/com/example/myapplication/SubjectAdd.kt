//화면에 과목를 추가 - 현재화면은 과목 선택 상황 ex) 일본어를 선택한후 jlpt 5급 ~ 1급 중 선택하는 상황

package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.SubjectSelectBinding
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog



class SubjectAdd : AppCompatActivity() {
    private var mBinding: SubjectSelectBinding? = null
    //매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = SubjectSelectBinding.inflate(layoutInflater)
        //getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의
        // 인스턴스를 활용하여 생성된 뷰를 액티비티에 표시합니다.
        setContentView(binding.root)

        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.subject_select, null)

        val subjectadddialog = SubjectAddDialog(this)
        binding.subjectAddBtn.setOnClickListener {
            subjectadddialog.MysubjectadddDdalog()
        }

    }

    fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
