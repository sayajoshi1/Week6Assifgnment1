package com.saya.week6assignment1.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.saya.week6assignment1.R
import com.saya.week6assignment1.Storage
import com.saya.week6assignment1.model.Student


class AddStudentFragment : Fragment() {

    private lateinit var etname: EditText
    private lateinit var etaddress: EditText
    private lateinit var etage: EditText
    private lateinit var etimageurl: EditText
    private lateinit var btnmale : RadioButton
    private lateinit var btnothers: RadioButton
    private lateinit var btnfemale : RadioButton
    private lateinit var btnsave: Button

    private var userImageURL = ""
    var res : Boolean = true
    private var gender = "Not Specified"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add_student, container, false)
        etname=view.findViewById(R.id.etname)
        etaddress=view.findViewById(R.id.etaddress)
        etage=view.findViewById(R.id.etage)
        etimageurl= view.findViewById(R.id.etimageurl)
        btnsave=view.findViewById(R.id.btnsave)
        btnfemale=view.findViewById(R.id.btnfemale)
        btnmale=view.findViewById(R.id.btnmale)
        btnothers=view.findViewById(R.id.btnothers)


        btnmale.setOnClickListener {
            gender = "Male"
        }
        btnfemale.setOnClickListener {
            gender = "Female"
        }
        btnothers.setOnClickListener {
            gender = "Others"
        }

        btnsave.setOnClickListener {
            if(validateInput()) {
                var fullname = etname.text.toString()
                userImageURL = etimageurl.text.toString()
                var age = etage.text.toString()
                var address = etaddress.text.toString()
                Storage().appendStudent(Student(fullname, userImageURL, age, address, gender))
                Toast.makeText(view?.context, "Student Added Sucessfully", Toast.LENGTH_LONG).show()
                etname.setText("")
                etimageurl.setText("")
                etaddress.setText("")
                etage.setText("")
            }else{
                Toast.makeText(view?.context, "Try Again", Toast.LENGTH_SHORT).show()
            }
        }
        return  view
    }
    private fun validateInput(): Boolean {

        when {
            TextUtils.isEmpty(etname.text) -> {
                etname.error = "This field should not be empty"
                etname.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etimageurl.text) -> {
                etimageurl.error = "This field should not be empty"
                etimageurl.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etaddress.text) -> {
                etaddress.error = "This field should not be empty"
                etaddress.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etage.text) -> {
                etage.error = "This field should not be empty"
                etage.requestFocus()
                res = false
            }
        }

        return res

    }





}