package com.example.firebasephoneauth.fragment

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.firebasephoneauth.R
import com.example.firebasephoneauth.databinding.FragmentFirstBinding
import com.example.firebasephoneauth.databinding.FragmentSplashBinding
import com.google.firebase.auth.FirebaseAuth

class SplashFragment: Fragment() {

    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()


        object : CountDownTimer(2000, 1000) {
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                if (auth.currentUser != null) {
                    findNavController().navigate(R.id.action_splashFragment_to_thirdFragment)
                } else {
                    findNavController().navigate(R.id.action_splashFragment_to_firstFragment)
                }
            }
        }.start()


    }
}