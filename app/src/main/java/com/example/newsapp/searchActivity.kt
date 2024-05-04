package com.tuaplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

public class MainActivity extends AppCompatActivity {

    private MotionLayout motionLayout;
    private TextView textViewDiscover;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupListeners();
    }

    private void initializeViews() {
    //aqui iran las views
        motionLayout = findViewById(R.id.container);
        textViewDiscover = findViewById(R.id.textView);
        backButton = findViewById(R.id.backButton);
    }

    private void setupListeners() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Manejar el evento de clic del botón de regreso
                finish(); // Ejemplo de cerrar la actividad
            }
        });

    }
}
