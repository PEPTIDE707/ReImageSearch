package com.example.reimagesearch.feature.bookmark

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.reimagesearch.MainActivity
import com.example.reimagesearch.databinding.FragmentBookmarkBinding
import com.example.reimagesearch.model.SearchItemModel


/**
 * 사용자의 북마크를 표시하는 프래그먼트
 */
class BookmarkFragment : Fragment() {

    private lateinit var mContext: Context

    //바인딩 객체를 null 허용으로 설정(프래그먼트의 뷰가 파괴될 때 null 처리하기 위함)
    private var binding: FragmentBookmarkBinding? = null
    private lateinit var adapter: BookmarkAdapter

    //사용자의 좋아요를 받은 항목을 저장하는 리스트
    private var likedItems: List<SearchItemModel> = listOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // MainActivity로부터 좋아요 받은 항목 가져옴
        val mainActivity = activity as MainActivity
        likedItems = mainActivity.likedItems

        Log.d("BookmarkFragment", "likedItems size = ${likedItems.size}")

        //어댑터 설정
        adapter = BookmarkAdapter(mContext).apply {
            items = likedItems.toMutableList()
        }

        //바인딩 및 RecyclerView 설정
        binding = FragmentBookmarkBinding.inflate(inflater, container, false).apply {
            rvBookmark.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            rvBookmark.adapter = adapter
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //메모리 누수를 방지하기 위해 뷰가 파괴될 때 바인딩 객체를 null로 설정
        binding = null
    }
}