package com.example.daviseditor

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

const val CLEAR_BUTTON_ID = 1
const val UPPERCASE_BUTTON_ID = 2
const val EDITTEXT_ID = 3

class SimpleEditorActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = createLayout()

        createEditText(layout)
        createUpperCaseButton(layout)
        createClearButton(layout)

        setContentView(layout)
    }

    private fun createClearButton(layout: LinearLayout) {
        val clearButton = Button(this)
        clearButton.setId(CLEAR_BUTTON_ID)
        clearButton.setText("Clear text")
        clearButton.setOnClickListener(this)

        val clearLayout = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );

        clearButton.setLayoutParams(clearLayout)
        layout.addView(clearButton)
    }

    private fun createUpperCaseButton(layout: LinearLayout) {
        val uppercaseButton = Button(this)
        uppercaseButton.setId(UPPERCASE_BUTTON_ID)
        uppercaseButton.setText("Uppercase all")
        uppercaseButton.setOnClickListener(this)

        val uppercaseLayout = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        uppercaseButton.setLayoutParams(uppercaseLayout)
        layout.addView(uppercaseButton)
    }

    private fun createEditText(layout: LinearLayout) {
        val editText = EditText(this)
        editText.setId(EDITTEXT_ID)
        editText.setBackgroundColor(Color.CYAN)
        editText.setGravity(Gravity.TOP)

        val editTextLayout = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
            1f
        )

        editText.setLayoutParams(editTextLayout)
        layout.addView(editText)
    }

    private fun createLayout(): LinearLayout {
        val layout = LinearLayout(this)
        layout.setOrientation(LinearLayout.VERTICAL)
        return layout
    }

    override fun onClick(v: View?) {
        val editText = findViewById<EditText>(EDITTEXT_ID)

        if (v?.getId() == CLEAR_BUTTON_ID) {
            editText.setText("")
        } else if (v?.getId() == UPPERCASE_BUTTON_ID) {
            var text = editText.getText().toString()
            text = text.uppercase()
            editText.setText(text)
        }
    }
}
/*
Question 1.
The app is able to launch, but the edit text widget and both of the buttons are missing.

Question 2.
The edit text widget is pushed to the bottom of the layout, but everything still functions as expected.

Question 3.
The edit text widget takes up the full vertical height of the layout; the buttons are no longer visible.

Question 4.
The build fails and the following error is displayed: "The integer literal does not conform to the expected type Float"
This error is displayed because the value that we passed as the parameter is an integer, when it the method was expecting a Float.

Question 5.
The button that causes the text to transform to uppercase is no longer displayed in the app.

Question 6.
The upper case button is no longer the full-width of the layout, and is instead only as big as the text within it.

Question 7.
The upper case button is now the full vertical height of the layout.

Question 8.
The background color of the edit text widget is changed to red.

Question 9.
editText.setTextColor(Color.WHITE)
editText.setBackgroundColor(Color.BLACK)

Question 10.
The following error is produced:
"Unresolved reference. None of the following candidates is applicable because of receiver type mismatch:
public fun kotlin.text.StringBuilder /* = java.lang.StringBuilder */.clear(): kotlin.text.StringBuilder /* = java.lang.StringBuilder */ defined in kotlin.text"

This error is thrown because the clear() method is not implemented for the type of object receiving the message.

Question 11.
The build fails with the following error:
"Not enough information to infer type variable T"

When you remove the cast type, the compiler is unable to infer the type of object.

Question 12.
The build fails with the following error:
"Type expected"

The code seems to be trying to cast the variable assignment as an EditText object, but this is not
the correct way to find an EditText widget. The interface is expecting to be provided the type of object
that implements the interface.

Question 13.
The app still functions as expected.

Question 14.
The app still functions as expected.

Question 15.
The following error is displayed:
"Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type View?"

This is because the type for the parameter in the function definition used the safe operator, so
references to that variable also require the safe operator.

Question 16.
https://developer.android.com/reference/android/graphics/Color

Question 17.
Alpha, Green, Red, and Blue.

Question 18.
android.widget.TextView

Question 19.
Two public methods are implemented, not counting the constructors.

Question 20.
"A layout that arranges other views either horizontally in a single column or vertically in a single row."
 */




