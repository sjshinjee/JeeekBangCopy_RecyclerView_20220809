package com.example.jeeekbangcopy_recyclerview_20220809

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jeeekbangcopy_recyclerview_20220809.adapters.RoomRecyclerViewAdapter
import com.example.jeeekbangcopy_recyclerview_20220809.databinding.ActivityMainBinding
import com.example.jeeekbangcopy_recyclerview_20220809.datas.RoomData

class MainActivity : AppCompatActivity() {

    // 멤버변수 binding 에 ActivityMainBinding 자료형을 넣을거라 선언
    lateinit var binding: ActivityMainBinding

    val mRoomList = ArrayList<RoomData>()

    lateinit var mRoomAdapter : RoomRecyclerViewAdapter

    //지금까지는 8/9오전수업 끝부분 onCreate내부에 코드를 다 작성했다
    ///But이러면 가독성이 굉장히 떨어지고 나중에 어디서 뭘 하는지 헷갈린다 & onCreate내부에는 코드 작성을 많이 안하는게 좋다
    ////Coz onResume이라든가 하는 함수들을 활용할때 더미데이터나 룸어댑터 초기화 한거 그리고 바인딩으로 묶어준것들을
    //5) onResume과 같은 함수들 내부에 다시 작성해줘야 한다 So왠만하면 function으로 다 묶을거다

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //더미 데이터 생성 자리였었음

       //룸 어댑터 초기와와 바인딩2개 자리였었음

        setupEvents()
        setValues()

    }
    //6)Event들이 일어날 코드들은 모두 이 함수 내부에 넣어줄거다(별도의 이벤트 처리는 모두 이 함수 안에서 할거다)
    fun setupEvents(){

    }

    //7)뭔가 처음에 값이 초기화 되는 것들은 모두 이 함수 안에 넣을거다(그래서 어댑터 초기와와 바인딩들 다 여기안으로 넣어줌)
    fun setValues(){
        getDataFromServer()

        mRoomAdapter = RoomRecyclerViewAdapter(this, mRoomList)
        binding.roomRecyclerView.adapter = mRoomAdapter

        binding.roomRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    //8)더미생성들도 이 안으로 넣어준다 (뭔가 데이터를 서버에서 받아온다)
    fun getDataFromServer() {

        mRoomList.clear()

        mRoomList.add(RoomData(8000, "마포구 서교동", 1, "망원/홍대역 풀옵션 넓은 원룸"))
        mRoomList.add(RoomData(28000, "마포구 서교동", 5, "홍대입구역 풀옵션 투룸"))
        mRoomList.add(RoomData(12000, "마포구 서교동", 2, "망원/홍대역 인근 신축 원룸 전세"))
        mRoomList.add(RoomData(12000, "마포구 망원동", 3, "홍대역 풀옵션 넓은 원룸"))
        mRoomList.add(RoomData(15000, "마포구 망원동", 5, "테라스가 넓은 풀옵션 넓은 원룸"))
        mRoomList.add(RoomData(13000, "마포구 망원동", 3, "넓고 반듯한 신축 원룸"))
        mRoomList.add(RoomData(9000, "마포구 연남동", 2, "홍대역 풀옵션 넓은 원룸"))
        mRoomList.add(RoomData(7500, "마포구 연남동", -2, "연남동 연습 가능 연습실"))
        mRoomList.add(RoomData(26000, "마포구 연남동", 3, "강추!! 홍대역 테라스 넓은 원룸"))
        mRoomList.add(RoomData(5500, "마포구 연남동", 0, "홍대역 풀옵션 원룸"))

        mRoomAdapter.notifyDataSetChanged()

    }



}