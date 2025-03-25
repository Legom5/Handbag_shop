package legom.handbagshop.presentation.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import legom.handbagshop.databinding.FragmentProductBinding
import legom.handbagshop.presentation.viewmodel.ProductViewModel

class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding: FragmentProductBinding
        get() = _binding ?: throw RuntimeException("binding = null")

    private var porductId = 0



    private val viewModel by lazy {
        ViewModelProvider(this)[ProductViewModel::class.java]
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getInt(ID_PRODUCT)?.let {
            porductId = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProduct(porductId)
        viewModel.product.observe(viewLifecycleOwner){
            binding.productName.text = it.title
            binding.productCategory.text = it.category
            binding.productPrice.text = it.price
            Picasso.get().load(it.imageUrl).into(binding.imageProduct)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(id: Int) = ProductFragment().apply {
            arguments = Bundle().apply {
                putInt(ID_PRODUCT, id)
            }
        }

        const val ID_PRODUCT = "id product"
    }
}