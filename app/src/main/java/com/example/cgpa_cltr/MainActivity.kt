package com.example.cgpa_cltr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cgpa_cltr.ui.theme.CGPA_CltrTheme
data class Semseter(val grade: String,val credit: Int)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CGPA_CltrTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CGPA()
                }
            }
        }
    }
}

@Composable
fun CGPA() {
    var grade1 by remember { mutableStateOf("") }
    var credit1 by remember { mutableStateOf<Int?>(null) }
    var grade2 by remember { mutableStateOf("") }
    var credit2 by remember { mutableStateOf<Int?>(null) }
    var grade3 by remember { mutableStateOf("") }
    var credit3 by remember { mutableStateOf<Int?>(null) }
    var grade4 by remember { mutableStateOf("") }
    var credit4 by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = "Something Presents\n CGPA Calculator",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = Color(0xFF000000)
            )
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        SubjectText(subject = "Subject 1")
        GradeTextField(grade1) { grade1 = it }
        Space8dp()
        CreditTextField(credit1) { credit1 = it }
        Space8dp()
        SubjectText(subject = "Subject 2")
        GradeTextField(grade2) { grade2 = it }
        Space8dp()
        CreditTextField(credit2) { credit2 = it }
        Space8dp()
        SubjectText(subject = "Subject 3")
        GradeTextField(grade3) { grade3 = it }
        Space8dp()
        CreditTextField(credit3) { credit3 = it }
        Space8dp()
        SubjectText(subject = "Subject 4")
        GradeTextField(grade4) { grade4 = it }
        Space8dp()
        CreditTextField(credit4) { credit4 = it }
        Space8dp()
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {
                Button(
                    onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                        Color(0xFFBEABE0)
                    ), shape = RoundedCornerShape(15.dp)
                ) {
                    Text(
                        text = "Calculate CGPA",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium))
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    modifier = Modifier
                        .width(177.dp)
                        .wrapContentHeight(),
                    color = Color(0xFF263238),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = "Your All Time\nCGPA : ", style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            fontSize = 16.sp,
                            color = Color(0xFFFFFFFF)
                        )
                    )

                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp),
                color = Color(0xFF263238),
                shape = RoundedCornerShape(15.dp)
            ) {
                Column() {
                    Text(
                        modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
                        text = "Previous Semester", style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            fontSize = 16.sp,
                            color = Color(0xFFFFFFFF)
                        )
                    )
                    Text(
                        text = "Gread: , credit: ",
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 16.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun Space8dp() {
    Spacer(modifier = Modifier.padding(top = 8.dp))
}

@Composable
fun SubjectText(subject: String) {
    Text(
        text = subject, modifier = Modifier.fillMaxWidth(), style = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = Color(0xFF000000)
        )
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GradeTextField(grade: String, onValueChange: (String) -> Unit) {
    TextField(
        value = grade,
        onValueChange = { text ->
            onValueChange(text)
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(47.dp),
        label = { Text(text = "Enter Grade", color = Color.White, fontSize = 12.sp) },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color(0xFF7E57C2)
        ),
        shape = RoundedCornerShape(15.dp),
        textStyle = TextStyle(fontSize = 12.sp, color = Color.White)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditTextField(credit: Int?, onValueChange: (Int?) -> Unit) {
    TextField(
        value = credit?.toString() ?: "",
        onValueChange = { text ->
            onValueChange(text.toIntOrNull())
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(47.dp),
        label = {
            Text(
                text = "Enter Credit",
                color = Color.Black,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium))
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color(0xFF7D8CCED)
        ),
        shape = RoundedCornerShape(15.dp),
        textStyle = TextStyle(
            fontSize = 12.sp,
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.poppins_medium))
        )
    )
}



@Preview(showBackground = true)
@Composable
fun CGPAPreview() {
    CGPA_CltrTheme {
        CGPA()

    }
}

