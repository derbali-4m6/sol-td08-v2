package ca.qc.sol_td08_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import ca.qc.sol_td08_v2.fragments.ChatFragment;

public class Numero2Activity extends AppCompatActivity implements ChatFragment.CommunicationChannel {

    ChatFragment senderTop, senderDown;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero2);
        senderTop = new ChatFragment();
        senderDown = new ChatFragment();
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container_top, senderTop, "Top");
        transaction.replace(R.id.container_down, senderDown, "Down");
        transaction.commit();
    }


    @Override
    public void sendMessage(String message, String tag) {
        //Toast.makeText(this, tag + ": " + message, Toast.LENGTH_LONG ).show();
        if(tag.equals("Top")) {
           senderDown.receiveMessage(message);
        }else if(tag.equals("Down")) {
            senderTop.receiveMessage(message);
        }
    }
}