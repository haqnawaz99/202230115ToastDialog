package haqnawaz.org.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button, buttonAlert, buttonAlert1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        buttonAlert = findViewById(R.id.button_alert_dialog);
        buttonAlert1 = findViewById(R.id.button_alert_dialog1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.my_layout, (ViewGroup) findViewById(R.id.my_toast_viewgroup));

//                TextView text = layout.findViewById(R.id.textView);
//                text.setText("Customized Toast");
//
//                ImageView image = layout.findViewById(R.id.imageView);
//                image.setImageResource(R.drawable.ic_baseline_3p_24);

//                Toast toast = new Toast(MainActivity.this);
//                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 350);
//                toast.setDuration(Toast.LENGTH_LONG);
//                toast.setView(layout);
//                toast.show();
            }
        });

        buttonAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("It is message");
                builder.setTitle("Title");
                builder.setCancelable(false);
                builder.setPositiveButton("Positive Button",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int asdf)
                            { finish();}
                });
                builder.setNegativeButton("Negative Button",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    { dialog.cancel(); }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        buttonAlert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setIcon(R.drawable.ic_baseline_3p_24)
                        .setTitle("Test Dialog")
                        .setMessage("Do you want to leave us")
                        .setPositiveButton("Leave", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Stay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setNeutralButton("What up", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Click Leave to close and Stay to cancel",
                                        Toast.LENGTH_LONG).show();
                            }
                        }).show();

            }
        });
    }
}