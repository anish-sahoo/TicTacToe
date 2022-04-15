package com.anish.app1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button[][] matrix = new Button[3][3];
    String[][] tictactoe = new String[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matrix[0][0] = findViewById(R.id.b_0_0);
        matrix[0][1] = findViewById(R.id.b_0_1);
        matrix[0][2] = findViewById(R.id.b_0_2);
        matrix[1][0] = findViewById(R.id.b_1_0);
        matrix[1][1] = findViewById(R.id.b_1_1);
        matrix[1][2] = findViewById(R.id.b_1_2);
        matrix[2][0] = findViewById(R.id.b_2_0);
        matrix[2][1] = findViewById(R.id.b_2_1);
        matrix[2][2] = findViewById(R.id.b_2_2);

        reset(" ");
    }

    public void click00(View view){
        if(tictactoe[0][0].equals(" ")) {
            tictactoe[0][0] = "X";
            matrix[0][0].setText("X");
            if (notWin()) {
                generateMove();
                notWin();
            }
        }
    }
    public void click01(View view){
        if(tictactoe[0][1].equals(" ")) {
            tictactoe[0][1] = "X";
            matrix[0][1].setText("X");
            if (notWin()) {
                generateMove();
                notWin();
            }
        }
    }
    public void click02(View view){
        if(tictactoe[0][2].equals(" ")) {
            tictactoe[0][2] = "X";
            matrix[0][2].setText("X");
            if (notWin()) {
                generateMove();
                notWin();
            }
        }
    }
    public void click10(View view){
        if(tictactoe[1][0].equals(" ")) {
            tictactoe[1][0] = "X";
            matrix[1][0].setText("X");
            if (notWin()) {
                generateMove();
                notWin();
            }
        }
    }
    public void click11(View view){
        if(tictactoe[1][1].equals(" ")) {
            tictactoe[1][1] = "X";
            matrix[1][1].setText("X");
            if (notWin()) {
                generateMove();
                notWin();
            }
        }
    }
    public void click12(View view){
        if(tictactoe[1][2].equals(" ")) {
            tictactoe[1][2] = "X";
            matrix[1][2].setText("X");
            if (notWin()) {
                generateMove();
                notWin();
            }
        }
    }
    public void click20(View view){
        if(tictactoe[2][0].equals(" ")) {
            tictactoe[2][0] = "X";
            matrix[2][0].setText("X");
            if (notWin()) {
                generateMove();
                notWin();
            }
        }
    }
    public void click21(View view){
        if(tictactoe[2][1].equals(" ")) {
            tictactoe[2][1] = "X";
            matrix[2][1].setText("X");
            if (notWin()) {
                generateMove();
                notWin();
            }
        }
    }
    public void click22(View view){
        if(tictactoe[2][2].equals(" ")) {
            tictactoe[2][2] = "X";
            matrix[2][2].setText("X");
            if (notWin()) {
                generateMove();
                notWin();
            }
        }
    }

    void generateMove() {
        Random r = new Random();
        int row = r.nextInt(3);
        int column = r.nextInt(3);
        if(tictactoe[row][column].equals(" ")) {
            tictactoe[row][column] = "O";
            matrix[row][column].setText("O");
        }
        else generateMove();
    }

    boolean notWin(){
        if(hasOpenSpace()){
            if(check("O")){
                set(1);
                return false;
            }
            if(check("X")) {
                set(0);
                return false;
            }
        }
        if(!hasOpenSpace()){
            if(check("O")){
                set(1);
                return false;
            }
            if(check("X")) {
                set(0);
                return false;
            }
            else {
                set(2);
                return false;
            }
        }
        else return true;
    }
    boolean hasOpenSpace(){
        int a = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(tictactoe[i][j].equals(" "))
                    a++;
            }
        }
        return a != 0;
    }
    boolean check(String c){
        int[] horizontal = new int[3], vertical = new int[3];
        int leftD = 0, rightD = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(tictactoe[i][j].equals(c))
                    horizontal[i]++;
                if(tictactoe[j][i].equals(c))
                    vertical[i]++;
            }
            if(tictactoe[i][i].equals(c))
                leftD++;
            else if(tictactoe[i][3 - i - 1].equals(c))
                rightD++;
        }
        for (int i = 0; i < 3; i++) {
            if(horizontal[i] == 3 || vertical[i] == 3 || leftD == 3 || rightD == 3)
                return true;
        }
        if(tictactoe[0][2] == tictactoe[1][1] && tictactoe[1][1] == tictactoe[2][0] && tictactoe[1][1].equals(c))
            return true;
        return false;
    }

    public void reset(View view){
        TextView t = findViewById(R.id.textView3);
        t.setText("");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tictactoe[i][j] = " ";
                matrix[i][j].setText(tictactoe[i][j]);
            }
        }
    }
    public void reset(String a){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tictactoe[i][j] = a;
                matrix[i][j].setText(tictactoe[i][j]);
            }
        }
    }

    @SuppressLint("SetTextI18n")
    void set(int a){
        TextView textView = findViewById(R.id.textView3);
        switch (a){
            case(0):
                textView.setText("You Win!");
                reset(":D");
                break;
            case(1):
                textView.setText("You Lost!");
                reset(":(");
                break;
            case(2):
                textView.setText("Tied!");
                reset("'_'");
                break;
        }

    }
}
