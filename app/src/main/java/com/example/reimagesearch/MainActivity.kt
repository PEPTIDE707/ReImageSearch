package com.example.reimagesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.reimagesearch.feature.bookmark.BookmarkFragment
import com.example.reimagesearch.databinding.ActivityMainBinding
import com.example.reimagesearch.model.SearchItemModel
import com.example.reimagesearch.feature.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //좋아요를 눌러 선택된 아이템을 저장하는 리스트
    var likedItems: ArrayList<SearchItemModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼의 클릭 리스너를 설정
        //SearchFragment와 BookmarkFragment 간의 전환
        binding.run {
            btnSearchFragment.setOnClickListener{
                setFragment(SearchFragment())
            }
            btnBookmarkFragment.setOnClickListener {
                setFragment(BookmarkFragment())
            }
        }
        //앱 시작 시 기본적으로 SearchFragment를 표시
        setFragment(SearchFragment())
    }

    //주어진 프래그먼트를 화면에 표시하는 함수
    private fun setFragment(frag: Fragment){
        supportFragmentManager.commit{
            replace(R.id.frameLayout, frag)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }

    //좋아요가 눌린 아이템을 likeItems 리스트에 추가하는 함수
    fun addLikedItem(item: SearchItemModel) {
        if(!likedItems.contains(item)){
            likedItems.add(item)
        }
    }

    //좋아요가 취소된 아이템을 likeItems 리스트에서 제거하는 함수
    fun removeLikedItem(item: SearchItemModel) {
        likedItems.remove(item)
    }
}