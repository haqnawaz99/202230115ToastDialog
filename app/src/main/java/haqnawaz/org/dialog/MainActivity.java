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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button, buttonAlert, buttonAlert1, buttonAlertList, buttonMC, buttonCustDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        buttonAlert = findViewById(R.id.button_alert_dialog);
        buttonAlert1 = findViewById(R.id.button_alert_dialog1);
        buttonAlertList = findViewById(R.id.button_alert_dialog_with_list);
        buttonMC = findViewById(R.id.button_alert_dialog_with_mc);
        buttonCustDialog = findViewById(R.id.button_customized_dialog);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Clicked!", Toast.LENGTH_LONG).show();
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.my_layout,
                        (ViewGroup) findViewById(R.id.my_toast_viewgroup));

                TextView text = layout.findViewById(R.id.textView);
                text.setText("Customized Toast");
//
//                ImageView image = layout.findViewById(R.id.imageView);
//                image.setImageResource(R.drawable.ic_baseline_3p_24);

                Toast toast = new Toast(MainActivity.this);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 350);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }
        });

        buttonAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("It is message");
                builder.setTitle("Title");
                builder.setCancelable(true);
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

        buttonAlertList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] Colors = {"Red", "Green", "Blue"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("SetColor")
                        .setItems(Colors, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity
                             .this, Colors[which], Toast.LENGTH_SHORT).show();
                        }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        buttonMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] Colors = {"Blue", "Red", "Green"};
                ArrayList<Integer> selectedItems = new ArrayList();  // Where we track the selected items

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select options")
                        .setMultiChoiceItems(Colors, null,
                                new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked)
                            { if (isChecked) {
                                selectedItems.add(which);
                            } else if (selectedItems.contains(which)) {
                                selectedItems.remove(Integer.valueOf(which));
                            }
                            }
                        })
                        .setCancelable(false);
                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String msg = "";
                                        for (int i = 0; i < selectedItems.size(); i++)
                                        {
                                            msg = msg + "\n" + (i + 1) + " : " + Colors[ selectedItems.get(i)];
                                        }
                                        Toast.makeText(getApplicationContext(), "Total " + selectedItems.size() + " Items Selected.\n" + msg, Toast.LENGTH_SHORT).show();
                                    }                 })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"No Option Selected",Toast.LENGTH_SHORT).show();
                            }
                        });
                                AlertDialog dialog  = builder.create();
                                dialog.show();
            }
        });

        buttonCustDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

// Set the layout for the dialog
                LayoutInflater inflater = getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.login_dialog, null);
                builder.setView(dialogView);

// Add the buttons
                builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Login logic here
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

// Create the AlertDialog
                AlertDialog dialog = builder.create();

// Show the dialog
                dialog.show();

            }
        });
    }
}