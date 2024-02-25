package com.example.tutoriel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private StringBuilder inputStringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des composants
        resultTextView = findViewById(R.id.result);
        inputStringBuilder = new StringBuilder();

        // Attribution des écouteurs d'événements aux boutons
        setButtonClickListeners();
    }

    // Méthode pour attribuer les écouteurs d'événements aux boutons
    private void setButtonClickListeners() {
        // Liste des ID de vos boutons numériques et opérationnels
        int[] buttonIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btn_pls, R.id.btn_sub, R.id.btn_mul, R.id.btn_div,
                R.id.btn_comma};

        // Attribuer un écouteur d'événements à chaque bouton
        for (int buttonId : buttonIds) {
            Button button = findViewById(buttonId);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onButtonClick(button.getText().toString());
                }
            });
        }

        // Bouton égal
        Button equalButton = findViewById(R.id.btn_eq);
        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEqualButtonClick();
            }
        });

        // Bouton DEL
        Button deleteButton = findViewById(R.id.btn_del);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteButtonClick();
            }
        });
    }

    // Méthode appelée lorsqu'un bouton numérique ou opérationnel est cliqué
    private void onButtonClick(String buttonText) {
        inputStringBuilder.append(buttonText);
        updateResult();
    }

    // Méthode appelée lorsqu'on appuie sur le bouton égal
    private void onEqualButtonClick() {
        // Vous pouvez implémenter ici la logique pour évaluer l'expression
        // actuellement stockée dans inputStringBuilder et afficher le résultat
        // dans resultTextView. Assurez-vous de manipuler correctement
        // les erreurs d'expression.
    }

    // Méthode appelée lorsqu'on appuie sur le bouton DEL
    private void onDeleteButtonClick() {
        if (inputStringBuilder.length() > 0) {
            inputStringBuilder.deleteCharAt(inputStringBuilder.length() - 1);
            updateResult();
        }
    }

    // Mettre à jour le TextView avec le contenu de inputStringBuilder
    private void updateResult() {
        resultTextView.setText(inputStringBuilder.toString());
    }
}
