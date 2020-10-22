package com.example.asyctask_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Menu_act extends AppCompatActivity
{
    private ViewFlipper vf;
    private int [] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        vf = (ViewFlipper) findViewById (R.id.slider);

        for (int i = 0; i < images.length; i++)
        {
            flip_image(images [i]); // Interación Slider.
        }
    }

    // Configuración de Slider

    public void flip_image (int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i); // Añadir arreglo al ImageView.

        // Configuración de Slider

        vf.addView(view); // Añadir imágenes al ViewFlipper.
        vf.setAutoStart(true); // Inicia de forma automática.
        vf.setFlipInterval(2800); // Velocidad de cambio imágenes.

        // Sentido de Slider

        vf.setInAnimation(this, android.R.anim.slide_in_left); //Parte de Izquierda.
        vf.setOutAnimation(this, android.R.anim.slide_out_right); // Termina y sigue.
    }

    // Intent Explícito

    public void Maps (View v)
    {
        Intent i = new Intent (this, Maps_act.class);
        startActivity(i);

    }
}