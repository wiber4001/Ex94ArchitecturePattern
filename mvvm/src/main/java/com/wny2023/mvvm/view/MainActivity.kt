package com.wny2023.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.wny2023.mvvm.R
import com.wny2023.mvvm.databinding.ActivityMainBinding
import com.wny2023.mvvm.viewmodel.MyViewModel


class MainActivity : AppCompatActivity() {

    //3.MVVM[model-view-view model]
    //view와 model의 데이터를 연결(data binding)해 놓아서
    //model데이터가 변경될때 별도의 처리코드없이 view가 자동 갱신되는특징
    //1)Model -다른 패턴의 model과 동일[Item, ItemModel
    //2)View - 사용자가 볼 화면, 클릭 이벤트를 처리하여 ViewModel에게 model제어를 요청(activity, fragment)
    //3)ViewModel- 뷰와 모델을 연결하는 역할, view가 연결(binding)한 데이터를 제어하도록 요청하는 클래스가 있는 코드

    // ** View 는 ViewModel을 참조하고, ViewModel은 Model을 참조하고 있음
    // MVVM을 위해서는 [dataBinding: 데이터 바인딩] 기술을 이용하여 개발하는 것이 일반적임.
    // databinding은 뷰바인딩과 다르게 xml의 루트 요소가 layout 이어야만 클래스 생성
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //#view역할
        //레이아웃 xml과 연결하는 바인딩 클래스 [ activity_main.xml-->ActivityMainBinding]
        //import오류나면 gradle을 리셋
        //data binding 기능으로 액티비티에 setContentView()를 실행
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.vm= MyViewModel(this)

//        object: TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                TODO("Not yet implemented")
//            }
//
//        }

        //test용으로 viewmodel이 해야할 것을 써봄
//        val msg: ObservableField<String> = ObservableField("aaaa") //primative 8종이 아니면 모두 Field
//        binding.message=msg.get()

        //## MVVM의 장점 ##
        //1. MVP처럼 view와 presenter가 1:1대응되어 있지 않아서 화면이 많아져도 ViewModel은 재사용 가능
        //전체 파일 개수가 감소함
        //2. 사용자의 이벤트를 viewModel이 모두 하고 있기에 화면이 변경되어도 이벤트 처리에 대한 중복코드 필요없음
        //3. view는 viewModel을 참조하지만 viewModel은 view를 참조하지 않기에 view가 변경되어도
        //4. Activity나 Fragment의 코드가 가장 간결함.
        //## MVVM의 단점 ##
        //1. MVVM의 설계학습이 어려움
        //2. view처리가 많아지면 viewModel의 코드가 많아져서 결국 비대해짐


    }
}