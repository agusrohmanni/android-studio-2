package com.example.myflexiblefragment

import android.content.Intent
import android.os.Bundle
import android.os.ParcelFileDescriptor
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class DetailCategoryFragment : Fragment() {

    lateinit var tvCategoryName: TextView
    lateinit var tvCategoryDescription: TextView
    lateinit var  btnToProfile: Button
    lateinit var btnShowDialog: Button

    var description : String?= null
    companion object{
        var EXTRA_NAME = "Extra_name"
        var EXTRA_DESCRIPTION = "Extra_Description"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvCategoryName= view.findViewById(R.id.tv_categoryName)
        tvCategoryDescription= view.findViewById(R.id.tv_categoryDescription)
        btnToProfile= view.findViewById(R.id.btn_ToProfile)
        btnShowDialog= view.findViewById(R.id.btn_showDialog)

        btnToProfile.setOnClickListener{
            val mIntent = Intent(activity,ProfileActivity::class.java)
            startActivity(mIntent)
        }

        btnShowDialog.setOnClickListener{
            val mOptionDialogFragment = OptionDialogFragment()

            val mFragmentManager =  childFragmentManager
            mOptionDialogFragment.show(mFragmentManager,OptionDialogFragment::class.java.simpleName)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null){
            val descFromBundel = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundel
        }

        if (arguments != null){
            val categoryName = arguments?.getString(EXTRA_NAME)
            tvCategoryName.text= categoryName
            tvCategoryDescription.text= description
        }
    }

    internal var optionDialogListener: OptionDialogFragment.OnOptionDialogListener = object : OptionDialogFragment.OnOptionDialogListener {
        override fun onOptionChosen(text: String?) {
            Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
        }
    }
}