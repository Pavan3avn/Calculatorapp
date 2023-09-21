package com.pavan.calulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    String process;
    TextView textin, textout;
    Button buttonc, buttonac,buttonone,buttontwo,buttonthree,buttonfour,buttonfive,buttonsix,buttonseven,buttoneight,buttonnine,buttonzero;
    Button buttonplus,buttondiv, buttonmul,buttonminus,buttonequal,buttonmod,buttonopen,buttonclose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textin = findViewById(R.id.textin);
         textout = findViewById(R.id.textout);
         buttonac = findViewById(R.id.buttonac);
         buttonc = findViewById(R.id.buttonc);
         buttonone = findViewById(R.id.buttonone);
         buttontwo= findViewById(R.id.buttontwo);
        buttonthree= findViewById(R.id.buttonthree);
        buttonfour= findViewById(R.id.buttonfour);
        buttonfive = findViewById(R.id.buttonfive);
        buttonsix= findViewById(R.id.buttonsix);
        buttonseven= findViewById(R.id.buttonseven);
        buttoneight= findViewById(R.id.buttoneight);
        buttonnine= findViewById(R.id.buttonnine);
        buttonzero= findViewById(R.id.buttonzero);
        buttonplus = findViewById(R.id.buttonplus);
        buttonminus= findViewById(R.id.buttonminus);
        buttondiv= findViewById(R.id.buttondiv);
        buttonmod=findViewById(R.id.buttonmod);
        buttonmul=findViewById(R.id.buttonmul);
        buttonequal=findViewById(R.id.buttonequal);
        buttonopen=findViewById(R.id.open);
        buttonclose= findViewById(R.id.close);



        buttonone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText() + "1");
            }
        });
        buttontwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText() + "2");
            }
        });
        buttonthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText() + "3");
            }
        });
        buttonfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText() + "4");
            }
        });
        buttonseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText() + "7");
            }
        });
        buttonfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText() + "5");
            }
        });
        buttonsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText() + "6");
            }
        });
        buttoneight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText() + "8");
            }
        });
        buttonnine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText() + "9");
            }
        });
        buttonzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText() + "0");
            }
        });
        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText() + "+");
            }
        });
        buttonmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText() + "*");
            }
        });
        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText() + "/");
            }
        });
        buttonmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText() + "%");
            }
        });
        buttonac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText("");
                textout.setText("");
            }
        });
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(textin.getText().toString().length() < 1){
                    textin.setText("");
                }else{
                    textin.setText(textin.getText().toString().substring(0,textin.length()-1));
                }

            }
        });
        buttonequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textin.getText().toString();

                process = process.replaceAll("x","*");
                process = process.replaceAll("%","/100");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String result = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    result =  rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }
                catch (Exception e){
                    result = "error";
                }
                textout.setText(result);

            }
        });

        Boolean check = false;

        buttonopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText()+"(");

            }
        });
        buttonclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textin.setText(textin.getText()+")");
            }
        });





    }
}