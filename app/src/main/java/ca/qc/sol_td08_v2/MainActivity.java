package ca.qc.sol_td08_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ca.qc.sol_td08_v2.fragments.Fragment1;
import ca.qc.sol_td08_v2.fragments.Fragment2;
import ca.qc.sol_td08_v2.fragments.Fragment3;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_fragment_container, new Fragment1());
        transaction.commit();
    }

    public void ChargerFragment1(View view) {
        Fragment fragment  = manager.findFragmentById(R.id.main_fragment_container);
        if(fragment != null && !(fragment instanceof Fragment1)){
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.main_fragment_container, new Fragment1());
            transaction.commit();
        }
    }

    public void ChargerFragment2(View view) {
        Fragment fragment  = manager.findFragmentById(R.id.main_fragment_container);
        if(fragment != null && !(fragment instanceof Fragment2)){
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.main_fragment_container, new Fragment2());
            transaction.commit();
        }
    }

    public void ChargerFragment3(View view) {
        Fragment fragment  = manager.findFragmentById(R.id.main_fragment_container);
        if(fragment != null && !(fragment instanceof Fragment3)){
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.main_fragment_container, new Fragment3());
            transaction.commit();
        }
    }

    public void AllerVersNumero2(View view) {
        startActivity(new Intent(this, Numero2Activity.class));
    }
}