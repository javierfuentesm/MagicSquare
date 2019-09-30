package com.example.magicsquare;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
public class SegundaActivity extends Activity{
    TextView    jet, tv;
    Bundle      bdl;
    TableLayout tbl;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);
        bdl = getIntent().getExtras();
        int n = Integer.parseInt(bdl.getString("Numero"));
        jet = findViewById(R.id.xet1);
        tbl = findViewById(R.id.tableL);
        int[][] myData = this.generateSquare(n);
        jet.append("Suma de cada columna " + Integer.toString(n*(n*n+1)/2));
        for(int i=0; i < n; i++){
            TableRow row= new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            for(int j=0; j < n; j++) {
                tv = new TextView(this);
                tv.setText(Integer.toString(myData[i][j]));
                row.addView(tv);
            }
            tbl.addView(row, i);
        }
    }

    private int [][] generateSquare(int n){
        int[][] magicSquare = new int[n][n];

        // Initialize position for 1
        int i = n/2;
        int j = n-1;

        // One by one put all values in magic square
        for (int num=1; num <= n*n; )
        {
            if (i==-1 && j==n) //3rd condition
            {
                j = n-2;
                i = 0;
            }
            else
            {
                //1st condition helper if next number
                // goes to out of square's right side
                if (j == n)
                    j = 0;

                //1st condition helper if next number is
                // goes to out of square's upper side
                if (i < 0)
                    i=n-1;
            }

            //2nd condition
            if (magicSquare[i][j] != 0)
            {
                j -= 2;
                i++;
                continue;
            }
            else
                //set number
                magicSquare[i][j] = num++;

            //1st condition
            j++;  i--;
        }

        for(i=0; i<n; i++)
        {
            for(j=0; j<n; j++)
                System.out.print(magicSquare[i][j]+" ");
            System.out.println();
        }
        return magicSquare;
    }
}