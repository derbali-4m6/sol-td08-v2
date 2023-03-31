package ca.qc.sol_td08_v2.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ca.qc.sol_td08_v2.R;

public class ChatFragment extends Fragment {

    public interface  CommunicationChannel{
        void sendMessage(String message, String tag);
    }

    CommunicationChannel channel;

    @Override
    public void onAttach(@NonNull Context context) { //le context représente l'activité conteneur du fragment
        super.onAttach(context);
        channel = (CommunicationChannel) context;
    }

    EditText txtMessgae;
    Button btnSend;
    TextView lblResult;

    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        txtMessgae = view.findViewById(R.id.chat_txt_message);
        btnSend = view.findViewById(R.id.chat_btn_send);
        lblResult = view.findViewById(R.id.chat_lbl_result);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = txtMessgae.getText().toString();
                channel.sendMessage(message, getTag());
            }
        });
        return view;
    }

    public void receiveMessage(String message) {
        lblResult.setText(message);
    }
}