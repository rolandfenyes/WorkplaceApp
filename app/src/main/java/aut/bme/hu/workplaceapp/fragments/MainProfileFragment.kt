package aut.bme.hu.workplaceapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import aut.bme.hu.workplaceapp.data.DataManager
import aut.bme.hu.workplaceapp.data.Person
import kotlinx.android.synthetic.main.profile_main.*

class MainProfileFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(aut.bme.hu.workplaceapp.R.layout.profile_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val person: Person = DataManager.person

        tvName.text = person.name
        tvEmail.text = person.email
        tvAddress.text = person.address
    }
}