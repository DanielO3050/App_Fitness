package com.example.asyctask_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity
{
    private ProgressBar progress;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress =  (ProgressBar) findViewById(R.id.pb);
        btn = (Button) findViewById(R.id.btn);

        progress.setVisibility (View.INVISIBLE); // Desaparece el Progress Bar.

        // Elemento OnClick de la Interfaz
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                new Task().execute();
            }
        });
    }

    // Tarea Asíncrona

    class Task extends AsyncTask<String, Void, String>
    {

        @Override //Configuración inicial del Progress Bar.
        protected void onPreExecute()
        {
            progress.setVisibility(View.VISIBLE); // Progress Bar Visible.
        }

        @Override // Tarea pesada.
        protected String doInBackground(String... strings)
        {
            for (int i = 1; i <= 10; i++)
            {
                try
                {
                    Thread.sleep(1000);
                }

                catch (Exception e)
                {
                    e.printStackTrace(); // Ejecutar tarea asíncrona.
                }
            }
            return null;
        }

        @Override // Después de mi tarea pesada.
        protected void onPostExecute(String s)
        {
            progress.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(), Menu_act.class);
            startActivity(i);
        }
    }


}