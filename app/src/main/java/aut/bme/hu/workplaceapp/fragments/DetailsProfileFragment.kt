package aut.bme.hu.workplaceapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import aut.bme.hu.workplaceapp.data.DataManager
import aut.bme.hu.workplaceapp.data.Person
import kotlinx.android.synthetic.main.profile_detail.*

class DetailsProfileFragment: Fragment()  {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(aut.bme.hu.workplaceapp.R.layout.profile_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val person: Person = DataManager.person

        tvId.text = person.id
        tvSSN.text = person.socialSecurityNumber
        tvTaxId.text = person.taxId
        tvRegistrationId.text = person.registrationId
    }
}