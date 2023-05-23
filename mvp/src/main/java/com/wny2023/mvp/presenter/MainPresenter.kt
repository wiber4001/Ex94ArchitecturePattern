package com.wny2023.mvp.presenter

import com.wny2023.mvp.model.Item
import com.wny2023.mvp.model.ItemModel


// presenter라면 가져야할 기능을 기술한 인터페이스를 구현하여 실제 기능을 작성하는 클래스
class MainPresenter:MainContract.Presenter {

    // presenter는 view와 model을 연결해야 하기에 각각의 참조변수를 멤버로 보유
    //var view: MainActivity //이렇게 되면 강한결합(메인을바꾸면 여기도 바꿔줘야함)이 되어버림
    var view: MainContract.View?=null
    //1.view 역할을 수행하는 클래스는 MainContract.View 인터페이스를 구현하고 있기에
    //특정 Activity/Fragment를 직접 자료형으로 참조하고 있지 않음.(약한 결합)
    var model:ItemModel?=null
    //2.model 역할을 수행하는 클래스 참조변수

    //presenter가 연결할 2개의 참조변수를 생성 및 전달받는 메소드
    fun initial(view:MainContract.View){
        this.view=view
        model= ItemModel(view.getContext())
    }

    //view의 save버튼클릭 이벤트를 대신 처리해주는 기능메소드
    override fun clickSave(name: String, email: String) {
        model?.saveData(name,email)
    }

    override fun clickLoad() {
        //model에게 data를 요청
        var item:Item? = model?.loadData() //받아올때 null일수도 있으므로 ?써줌

        //view에게 data 출력을 요청
        item?.let { //scope연산자: if대신 사용, null이 아닐때 수행됨
            view?.showData(it) //it은 item 데이터임
        }

    }

}