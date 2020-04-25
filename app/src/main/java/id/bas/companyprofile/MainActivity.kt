package id.bas.companyprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import id.bas.companyprofile.ui.fragment.anggota.AnggotaFragment
import id.bas.companyprofile.ui.fragment.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment())
        navigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_home_black_24dp))
        navigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_supervisor_account_black_24dp))

        navigation.setOnClickMenuListener {
            when(it.id){
                1 -> loadFragment(HomeFragment())
                2 -> loadFragment(AnggotaFragment())
                else -> null

            }
        }

        navigation.show(1)
    }


    fun loadFragment (fragment : Fragment?) : Boolean{
        if (fragment != null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            return true
        }

        return false
    }
}
