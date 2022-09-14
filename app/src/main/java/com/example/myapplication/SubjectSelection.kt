package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.SubjectSelectBinding
import com.example.myapplication.databinding.TestSelectBinding.inflate
import java.io.BufferedReader
import java.io.File
import java.io.FileReader


class SubjectSelection : AppCompatActivity() {

    //전역 변수로 바인딩 객체 선언
    private var mBinding: SubjectSelectBinding? = null
    //매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        //액티비티에서 사용할 바인딩 클래스의 인스턴스 실행
        mBinding = SubjectSelectBinding.inflate(layoutInflater)

        //getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의
        // 인스턴스를 활용하여 생성된 뷰를 액티비티에 표시합니다.
        setContentView(binding.root)

        //이제부터 binding 바인딩 변수를 활용하여 xml 파일 내의 뷰 id 접근이 가능해집니다.
        //뷰 id도 파스칼케이스 + 카멜케이스의 네이밍 규칙 적용으로 인해서 rv_subject -> rvSubject로 자동 변역됨

        //맨처음 기동시 subject file이 있는지 체크

        binding.rvSubject.adapter = SubjectRecyclerViewAdapter(readSubjectData())

        binding.subjectAddBtn.setOnClickListener{
            val dialog = SubjectAddDialog(this)
            dialog.myDig()
        }

    }
    //프로젝트를 저장해놓은 텍스트 파일을 읽고 리사이클러뷰에 리스트로 전달한다.
    fun readSubjectData() : ArrayList<Subject> {

        val dir = filesDir.absolutePath
        val filename = "subject_data.txt"
        val file = File("$dir/$filename")
        val subjectlist = ArrayList<Subject>() //결과값을 저장할 StringBuffer

        if(!file.exists()){
            return subjectlist
        }

        val reader = FileReader(file) //file을 담아 fileReader로 reader 객체 생성
        val buffer = BufferedReader(reader) //속도 향상을 위해 BufferedReader로 reader를 담아 buffer 생성
        var temp = "" //한줄씩 읽은 내용을 저장할 temp

        while(true){
            temp = buffer.readLine() //buffer에서 한줄씩 내용을 꺼내어 temp에 저장
            if(temp == null)
                break
            else subjectlist.add(Subject(temp.replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(),""))) //입력받은 한줄에서 개행문자 제거
            // 추후에 subject 저장 형식이 달라지면 고쳐야할부분
            /*todo*/
        }
        buffer.close()
        return subjectlist
        //현재 subject 저장 텍스트파일의 형태는 과목명\n 반복의 형태

    }
    //프로젝트를 추가할 경우 데이터 텍스트에 목록을 추가
    /*todo*/
    fun writeSubjectData(){

    }

}