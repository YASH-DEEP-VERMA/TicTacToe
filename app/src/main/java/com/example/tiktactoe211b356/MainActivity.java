package com.example.tiktactoe211b356;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imgClicked=-1;
    int player=1; //cross
    int [][]winningStates={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []gameState={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view){
        ImageView v=(ImageView) view;
        int tag=Integer.parseInt(v.getTag().toString());
        imgClicked= gameState[tag];
        if(isWinner==false && imgClicked==-1){
        if(player==1) {
            v.setImageResource(R.drawable.cross);
            gameState[tag]=1;
            Toast.makeText(this,tag+""+"cross",Toast.LENGTH_SHORT).show();
            player=2;
        }
        else{
            v.setImageResource(R.drawable.zero);
            gameState[tag]=2;
            Toast.makeText(this,tag+""+"zero",Toast.LENGTH_SHORT).show();
            player=1;

        }
        for (int i=0;i<winningStates.length;i++){
            if(gameState[winningStates[i][0]]==gameState[winningStates[i][1]] && gameState[winningStates[i][1]]==gameState[winningStates[i][2]] && gameState[winningStates[i][0]]>-1){
                Toast.makeText(this,"Winner is Player"+" "+(player==1?2:1),Toast.LENGTH_SHORT).show();
                isWinner=true;
            }

        }}
    }
    public void Reset(View view){
       androidx.gridlayout.widget.GridLayout gridLayout=findViewById(R.id.gridLayout);
        int totalImages=gridLayout.getChildCount();

        for(int i=0;i<totalImages;i++){
            ImageView vi=(ImageView) gridLayout.getChildAt(i);
            vi.setImageDrawable(null);
        }
        isWinner=false;
        imgClicked=-1;
        player=1;
        for(int i=0;i<gameState.length ;i++)
            gameState[i]=-1;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}