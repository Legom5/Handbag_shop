package legom.handbagshop.presentation.fragments

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import legom.handbagshop.R

fun Fragment.openFragment(f: Fragment){
    (activity as AppCompatActivity).supportFragmentManager
        .beginTransaction()
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        .replace(R.id.placeHolder, f)
        .commit()
}

fun AppCompatActivity.openFragment(f: Fragment){
    supportFragmentManager
        .beginTransaction()
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        .replace(R.id.placeHolder, f)
        .commit()
}