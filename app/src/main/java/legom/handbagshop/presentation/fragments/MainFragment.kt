package legom.handbagshop.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import legom.handbagshop.databinding.FragmentMainBinding
import legom.handbagshop.domain.entity.Category
import legom.handbagshop.domain.entity.Product
import legom.handbagshop.presentation.recycler.ProductAdapter
import kotlin.random.Random

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("binding = null")

    private lateinit var adapter: ProductAdapter

    private val list = mutableListOf<Product>()

    init {
        for (i in 0 until 100){
            val item = Product(i, "Name $i", "", Category.HANDBAG, "${(1000..10000).random()}")
            list.add(item)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        adapter.submitList(list)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupRecyclerView(){
        adapter = ProductAdapter()
        binding.rcView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

}